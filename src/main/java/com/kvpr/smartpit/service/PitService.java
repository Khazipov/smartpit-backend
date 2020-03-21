package com.kvpr.smartpit.service;

import com.kvpr.smartpit.dao.PitDao;
import com.kvpr.smartpit.model.Pit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PitService {

    @Autowired
    PitDao pitDao;

    public List<Pit> getAllPits() {
        return pitDao.findAll();
    }

}
