package com.sneakercity.sneakerstore.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollectionTest {

    private Collection collection;
    private List<Sneaker> sneakers;

    @BeforeEach
    public void setUp() {
        sneakers = new ArrayList<>();
        sneakers.add(new Sneaker(/* initialize with appropriate arguments */));
        sneakers.add(new Sneaker(/* initialize with appropriate arguments */));

        collection = new Collection(1, "Sneaker Collection", "A collection of sneakers", sneakers);
    }

    @Test
    public void testGetters() {
        assertEquals(1, collection.getId());
        assertEquals("Sneaker Collection", collection.getName());
        assertEquals("A collection of sneakers", collection.getDescription());
        assertEquals(sneakers, collection.getItems());
    }

    @Test
    public void testSetters() {
        collection.setId(2);
        collection.setName("Updated Collection");
        collection.setDescription("Updated description");
        List<Sneaker> updatedSneakers = new ArrayList<>();
        updatedSneakers.add(new Sneaker(/* initialize with different arguments */));
        collection.setItems(updatedSneakers);

        assertEquals(2, collection.getId());
        assertEquals("Updated Collection", collection.getName());
        assertEquals("Updated description", collection.getDescription());
        assertEquals(updatedSneakers, collection.getItems());
    }



}