package com.kvpr.smartpit.controller;

import com.kvpr.smartpit.model.Pit;
import com.kvpr.smartpit.service.PitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PitController {

    @Autowired
    PitService pitService;

    @GetMapping("/api")
    public String checkApi() {
        return "Welcome to API of HackUniversity KVPR Team solution! Yes, we are alive!";
    }

    @GetMapping("/api/pits")
    public List<Pit> getAllPits() {
        return pitService.getAllPits();
    }

    @PostMapping("/api/pits/upload")
    public ResponseEntity<String> uploadMultiplePits(@RequestBody List<Pit> pits) {
       pitService.savePits(pits);
       return ResponseEntity.ok("");
    }


}
