package com.sneakercity.sneakerstore.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class SneakerTest {
    private Sneaker sneaker;

    @BeforeEach
    public void setUp() {
        UUID sneakerId1 = UUID.randomUUID();
        sneaker = new Sneaker(sneakerId1, "Nike", "Air Max", "42", "A classic sneaker", "Running");
    }

    @Test
    public void testGetters() {
        assertEquals(1, sneaker.getId());
        assertEquals("Nike", sneaker.getMerk());
        assertEquals("Air Max", sneaker.getSchoennaam());
        assertEquals("42", sneaker.getSchoenmaat());
        assertEquals("A classic sneaker", sneaker.getBeschrijving());
        assertEquals("Running", sneaker.getCategorie());
    }

    @Test
    public void testSetters() {
        sneaker.setId(UUID.randomUUID());
        sneaker.setMerk("Adidas");
        sneaker.setSchoennaam("UltraBoost");
        sneaker.setSchoenmaat("43");
        sneaker.setBeschrijving("Comfortable running shoe");
        sneaker.setCategorie("Sport");

        assertEquals(2, sneaker.getId());
        assertEquals("Adidas", sneaker.getMerk());
        assertEquals("UltraBoost", sneaker.getSchoennaam());
        assertEquals("43", sneaker.getSchoenmaat());
        assertEquals("Comfortable running shoe", sneaker.getBeschrijving());
        assertEquals("Sport", sneaker.getCategorie());
    }
}