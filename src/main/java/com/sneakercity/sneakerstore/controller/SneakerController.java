package com.sneakercity.sneakerstore.controller;

import com.sneakercity.sneakerstore.model.Sneaker;
import com.sneakercity.sneakerstore.service.SneakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/sneakers")
public class SneakerController {

    @Autowired
    private SneakerService sneakerService;

    // Get all sneakers
    @GetMapping
    public List<Sneaker> getAllSneakers() {
        return sneakerService.getAllSneakers();
    }

    // Get a single sneaker by ID
    @GetMapping("/{id}")
    public ResponseEntity<Sneaker> getASneaker(@PathVariable UUID id) {
        return sneakerService.getSneakerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Add a single sneaker
    @PostMapping
    public Sneaker addSneaker(@RequestBody Sneaker sneaker) {
        return sneakerService.addSneaker(sneaker);
    }

    // Add multiple sneakers
    @PostMapping("/bulk")
    public List<Sneaker> addMultipleSneakers(@RequestBody List<Sneaker> sneakers) {
        return sneakerService.addMultipleSneakers(sneakers);
    }

    // Update a single sneaker
    @PutMapping("/{id}")
    public ResponseEntity<Sneaker> updateSneaker(@PathVariable UUID id, @RequestBody Sneaker sneaker) {
        return sneakerService.updateSneaker(id, sneaker)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a single sneaker
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSneaker(@PathVariable UUID id) {
        boolean isDeleted = sneakerService.deleteSneaker(id);
        if (isDeleted) {
            return ResponseEntity.ok().body("Sneaker deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sneaker not found with ID: " + id);
        }
    }

    // Filter sneakers
    @GetMapping("/filter")
    public List<Sneaker> filterSneakers(@RequestParam(required = false) String brand,
                                        @RequestParam(required = false) String color,
                                        @RequestParam(required = false) Double minPrice,
                                        @RequestParam(required = false) Double maxPrice,
                                        @RequestParam(required = false) Integer size) {
        return sneakerService.filterSneakers(brand, color, minPrice, maxPrice, size);
    }

    // Additional methods like getSneakersByBrand, getLatestSneakers, getSneakersSortedByPrice,
    // searchSneakers, getSneakersBySize etc. need to be implemented in the service
    // and added here as needed.

    // Example:
    @GetMapping("/brand/{brand}")
    public List<Sneaker> getSneakersByBrand(@PathVariable String brand) {
        // Implementation needed in service
        return List.of(); // Placeholder return
    }

    // ... other endpoints as required
}
