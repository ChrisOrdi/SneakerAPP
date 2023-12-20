package com.sneakercity.sneakerstore.controller;

import com.sneakercity.sneakerstore.model.Sneaker;
import com.sneakercity.sneakerstore.service.SneakerService;
import org.springframework.beans.factory.annotation.Autowired;
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


    // POST API methods

    @PostMapping("addASneaker")
    public Sneaker addSneaker(@RequestBody Sneaker sneaker) {
        return sneakerService.addSneaker(sneaker);
    }


    // PUT API methods
    @PutMapping("/updateASneaker")
    public ResponseEntity<Sneaker> updateSneaker(@PathVariable int id, @RequestBody Sneaker sneaker)
    {
        Sneaker updatedSneaker = sneakerService.updateSneaker(id, sneaker);
        if (updatedSneaker == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedSneaker);

    }

    /*
    @DeleteMapping("/{transactionId}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable int transactionId) {
        Optional<Transaction> deletedTranscation = transactionService.deleteTranscation(transactionId);
        if( deletedTranscation.isPresent()) { // if the trans action is present, return code 200
            return ResponseEntity.ok().build();
        } else { // else return error 400
            return ResponseEntity.notFound().build();
        }
    }
     */

    // DELETE API methods
 //   @DeleteMapping("/deleteASneaker")
//    public ResponseEntity<Void> deleteASneaker(@PathVariable int sneakerId) {
//        Optional<Sneaker> deletedSneaker = sneakerService.removeSneaker(sneakerId);
//        if (deletedSneaker.isPresent()) { // if the sneaker is present, return code 200
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
  //  }
}
