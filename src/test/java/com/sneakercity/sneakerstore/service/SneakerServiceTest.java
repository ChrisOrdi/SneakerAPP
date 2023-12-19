package com.sneakercity.sneakerstore.service;

import com.sneakercity.sneakerstore.model.Sneaker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SneakerServiceTest {

    private SneakerService sneakerService;

    @BeforeEach
    void setup(){
        sneakerService = new SneakerService();
    }

    @Test
    void should_getAllSneakersReturnsEmptyListInitially() {
        assertTrue(sneakerService.getAllSneakers().isEmpty());
    }

    @Test
    void should_getAllSneakersReturnsListOfAddedSneakers() {
        Sneaker sneaker1 = new Sneaker(0,"BrandA","Model A","45","Description A", "CategoryA");
        Sneaker sneaker2 = new Sneaker(0,"BrandB","Model B","45","Description B", "CategoryB");

        sneakerService.addSneaker(sneaker1);
        sneakerService.addSneaker(sneaker2);

        List<Sneaker> sneakers = sneakerService.getAllSneakers();
        assertEquals(2,sneakers.size()); // verwacht 2 sneakers, is dit gelijk aan het aantal records
        assertTrue(sneakers.contains(sneaker1)); // bestaat sneaker1
        assertTrue(sneakers.contains(sneaker2));// bestaat sneaker1
    }

    @Test
    void should_addSneakerAssignsIdAndAddsSneaker() {
        Sneaker sneaker = new Sneaker(0, "Brand C","Nike","45","Description C", "Category C");

        Sneaker adddedSneaker = sneakerService.addSneaker(sneaker);
        assertNotEquals(0, adddedSneaker.getId());
        assertTrue(sneakerService.getAllSneakers().contains(adddedSneaker));
    }
}