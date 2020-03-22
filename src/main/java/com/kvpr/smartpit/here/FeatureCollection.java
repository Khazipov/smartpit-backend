package com.kvpr.smartpit.here;

import java.util.Set;

public class FeatureCollection {
    private String type;
    private Set<Feature> features;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(Set<Feature> features) {
        this.features = features;
    }
}
