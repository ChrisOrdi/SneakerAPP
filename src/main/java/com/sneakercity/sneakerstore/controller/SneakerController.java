package com.sneakercity.sneakerstore.controller;

import com.sneakercity.sneakerstore.model.Sneaker;
import com.sneakercity.sneakerstore.service.SneakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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




}
