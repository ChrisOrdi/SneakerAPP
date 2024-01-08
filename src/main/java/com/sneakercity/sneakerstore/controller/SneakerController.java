package com.sneakercity.sneakerstore.controller;

import com.sneakercity.sneakerstore.model.Sneaker;
import com.sneakercity.sneakerstore.service.SneakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class SneakerController {

    private final SneakerService sneakerService;

    @Autowired
    public SneakerController(SneakerService sneakerService) {
        this.sneakerService = sneakerService;
    }


    // GET API methods
    // Get every sneaker

    @GetMapping("/getAllSneakers")
    public List<Sneaker> getAllSneakers() {
        return sneakerService.getAllSneakers();
    }

    @GetMapping("/getAllSneakerFromDB")
    public List<Sneaker> getAllSneakersFromDB() {
        return sneakerService.getAllSneakers();
    }

/*
    // Get a sneaker
    @GetMapping("/getASneaker")
    public Sneaker getASneaker(@RequestParam int id) {
        return sneakerService.getSneakerById(id);
    }


    // filter sneaker by criteria
    @GetMapping("/filterSneakers")
    public List<Sneaker> filterSneakers(@RequestParam(required = false) String brand,
                                        @RequestParam(required = false) String color,
                                        @RequestParam(required = false) Double minPrice,
                                        @RequestParam(required = false) Double maxPrice,
                                        @RequestParam(required = false) Integer size) {
        return sneakerService.filterSneakers(brand, color, minPrice, maxPrice, size);
    }


    // fetch sneaker by a specific brand
    @GetMapping("/sneakersByBrand/{brand}")
    public List<Sneaker> getSneakersByBrand(@PathVariable String brand) {
        return sneakerService.getSneakersByBrand(brand);
    }


    // get the most recently added sneakers
    @GetMapping("/latestSneakers")
    public List<Sneaker> getLatestSneakers(@RequestParam(required = false) Integer limit) {
        return sneakerService.getLatestSneakers(limit);
    }

    // get sneakers sorted by price
    @GetMapping("/sneakers/sortedByPrice")
    public List<Sneaker> getSneakersSortedByPrice(@RequestParam String order) {
        return sneakerService.getSneakersSortedByPrice(order);
    }


    // search sneakers by keyword
    @GetMapping("/sneakers/search")
    public List<Sneaker> searchSneakers(@RequestParam String keyword) {
        return sneakerService.searchSneakers(keyword);
    }

    @GetMapping("/sneakers/bySize")
    public List<Sneaker> getSneakersBySize(@RequestParam int size) {
        return sneakerService.getSneakersBySize(size);
    }





    // POST API methods


    // voeg 1 sneaker toe
    @PostMapping("addASneaker")
    public Sneaker addSneaker(@RequestBody Sneaker sneaker) {
        return sneakerService.addSneaker(sneaker);
    }

    @PostMapping("/addMultipleSneakers")
    public List<Sneaker> addMultipleSneakers(@RequestBody List<Sneaker> sneakers) {
        return sneakerService.addMultipleSneakers(sneakers);
    }


    // PUT API methods

    // update 1 senaker
    @PutMapping("/updateASneaker")
    public ResponseEntity<Sneaker> updateSneaker(@PathVariable int id, @RequestBody Sneaker sneaker) {
        Sneaker updatedSneaker = sneakerService.updateSneaker(id, sneaker);
        if (updatedSneaker == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedSneaker);

    }


    // DELETE API methods
    // verwijder 1 sneaker
    @DeleteMapping("/deleteSneaker")
    public ResponseEntity<?> deleteSneaker(@RequestParam int id) {
        boolean isDeleted = sneakerService.deleteSneaker(id);
        if (isDeleted) {
            return ResponseEntity.ok().body("Sneaker deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sneaker not found with ID: " + id);
        }
    }

 */




}
