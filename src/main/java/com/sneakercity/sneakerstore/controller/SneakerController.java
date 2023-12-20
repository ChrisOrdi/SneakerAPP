package com.sneakercity.sneakerstore.controller;

import com.sneakercity.sneakerstore.model.Sneaker;
import com.sneakercity.sneakerstore.service.SneakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SneakerController {

    private final SneakerService sneakerService;

    @Autowired
    public SneakerController(SneakerService sneakerService) {
        this.sneakerService = sneakerService;
    }


    /*
    GET API calls
    POST API calls
    PUT API calls
    DELETE API calls
     */


    // GET API methods
    // Get every sneaker

    @GetMapping("/getAllSneakers")
    public List<Sneaker> getAllSneakers() {
        return sneakerService.getAllSneakers();
    }

    @GetMapping("/getASneaker")
    public Sneaker getASneaker(@RequestParam int id) {
        return sneakerService.getSneakerById(id);
    }


    // POST API methods

    @PostMapping("addASneaker")
    public Sneaker addSneaker(@RequestBody Sneaker sneaker) {
        return sneakerService.addSneaker(sneaker);
    }


    // PUT API methods
    @PutMapping("/updateASneaker")
    public ResponseEntity<Sneaker> updateSneaker(@PathVariable int id, @RequestBody Sneaker sneaker) {
        Sneaker updatedSneaker = sneakerService.updateSneaker(id, sneaker);
        if (updatedSneaker == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedSneaker);

    }
    // DELETE API methods
//    @DeleteMapping("/deleteASneaker")
//    public ResponseEntity<Void> deleteASneaker(@PathVariable int sneakerId) {
//        Optional<Sneaker> deletedSneaker = sneakerService.deleteSneaker(sneakerId);
//        if (deletedSneaker.isPresent()) { // if the sneaker is present, return code 200
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @DeleteMapping("/deleteSneaker")
    public ResponseEntity<?> deleteSneaker(@RequestParam int id) {
        boolean isDeleted = sneakerService.deleteSneaker(id);
        if (isDeleted) {
            return ResponseEntity.ok().body("Sneaker deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sneaker not found with ID: " + id);
        }
    }


}
