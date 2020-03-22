package com.kvpr.smartpit.scheduller;

import com.google.gson.Gson;
import com.kvpr.smartpit.dao.PitDao;
import com.kvpr.smartpit.here.Feature;
import com.kvpr.smartpit.here.FeatureCollection;
import com.kvpr.smartpit.here.Geometry;
import com.kvpr.smartpit.model.Pit;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HEREDataImporterScheduled {

    @Value("${com.here.authToken}")
    private String authToken;

    @Value("${com.here.create.pit.url}")
    private String createPitUrl;

    @Autowired
    private PitDao pitDao;

    @Scheduled(fixedDelay = 20_000)
    public void updateFromDB() throws UnirestException {
        //Note: 30,60 - Saint-Petersburg
        List<Pit> pitList = pitDao.findPitsByDateUploadedIsNull();
        if (!pitList.isEmpty()) {
            importToHERE(pitList);
            pitList.forEach(pit -> pit.setDateUploaded(new Date()));
            pitDao.saveAll(pitList);
        }
    }

    private void importToHERE(List<Pit> pitList) throws UnirestException {
        FeatureCollection featureCollection = new FeatureCollection();
        Set<Feature> features = pitList.stream().map(this::convertToFeature).collect(Collectors.toSet());
        featureCollection.setType("FeatureCollection");
        featureCollection.setFeatures(features);

        Gson gson = new Gson();
        String pitsBody = gson.toJson(featureCollection);

        HttpResponse<String> response = Unirest.put(createPitUrl)
                .header("accept", "application/geo+json")
                .header("Content-Type", "application/geo+json")
                .header("Authorization", authToken)
                .body(pitsBody)
                .asString();
    }

    private Feature convertToFeature(Pit pit) {//59 - , 29 - long
        Geometry geometry = convertToGeometry(pit);
        Feature feature = new Feature();
        feature.setType("Feature");
        feature.setGeometry(geometry);
        return feature;
    }

    private Geometry convertToGeometry(Pit pit) {
        Geometry geometry = new Geometry();
        geometry.setType("Point");
        double[] coords = new double[2];
        coords[0] = pit.getLongitude();
        coords[1] = pit.getLatitude();
        geometry.setCoordinates(coords);
        return geometry;
    }
}
