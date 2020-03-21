package com.kvpr.smartpit.controller;

import com.kvpr.smartpit.model.Pit;
import com.kvpr.smartpit.service.PitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.ok("Your geopoints was saved in our database.");
    }

    @DeleteMapping("/api/pits/clear")
    public ResponseEntity<String> deleteAll() {
        pitService.deleteAllPits();
        return ResponseEntity.ok("All pits was deleted from our database.");
    }


}
