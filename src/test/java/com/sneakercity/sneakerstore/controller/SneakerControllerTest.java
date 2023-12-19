package com.sneakercity.sneakerstore.controller;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

import com.sneakercity.sneakerstore.model.Sneaker;
import com.sneakercity.sneakerstore.service.SneakerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class SneakerControllerTest {

    @Mock
    private SneakerService sneakerService;

    @InjectMocks
    private SneakerController sneakerController;

    private List<Sneaker> mockSneakers;

    @BeforeEach
    void setUp() {
        // Create mock Sneaker objects
        Sneaker sneaker1 = new Sneaker(1, "Nike", "Air Max", "42", "Comfortable running shoe", "Running");
        Sneaker sneaker2 = new Sneaker(2, "Adidas", "Ultra Boost", "43", "High performance sports shoe", "Sports");

        mockSneakers = Arrays.asList(sneaker1, sneaker2);
        when(sneakerService.getAllSneakers()).thenReturn(mockSneakers);
    }

    // The getAllSneakersTest method checks not only that the list is not null and has the correct
    // size but also verifies some of the attributes of the Sneaker objects in the list to ensure they match what was mocked.

    @Test
    void getAllSneakersTest() {
        List<Sneaker> sneakers = sneakerController.getAllSneakers();
        assertNotNull(sneakers, "The list of sneakers should not be null");
        assertEquals(2, sneakers.size(), "The size of sneaker list should be 2");

        // Additional assertions to check the contents of the list
        assertEquals("Nike", sneakers.get(0).getMerk());
        assertEquals("Air Max", sneakers.get(0).getSchoennaam());
        assertEquals("42", sneakers.get(0).getSchoenmaat());

        assertEquals("Adidas", sneakers.get(1).getMerk());
        assertEquals("Ultra Boost", sneakers.get(1).getSchoennaam());
        assertEquals("43", sneakers.get(1).getSchoenmaat());

        verify(sneakerService, times(1)).getAllSneakers();
    }

    @Test
     void should_addSneakerTest() {
        Sneaker newSneaker = new Sneaker(0, "New Balance", "574", "44", "Classic model", "Casual");
        when(sneakerService.addSneaker(any(Sneaker.class))).thenReturn(newSneaker);

        Sneaker addedSneaker = sneakerController.addSneaker(newSneaker);
        assertNotNull(addedSneaker);
        assertEquals("New Balance", addedSneaker.getMerk());
        assertEquals("574", addedSneaker.getSchoennaam());

        verify(sneakerService, times(1)).addSneaker(any(Sneaker.class));
    }

    @Test
     void addSneakerInvalidInputTest() {
        when(sneakerService.addSneaker(null)).thenThrow(new IllegalArgumentException("Invalid sneaker"));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sneakerController.addSneaker(null);
        });

        assertEquals("Invalid sneaker", exception.getMessage());
    }

    @Test
    public void testUpdateSneaker_Success() {
        int sneakerId = 1;
        Sneaker updatedSneaker = new Sneaker(sneakerId, "Adidas", "UltraBoost", "43", "A comfortable running shoe", "Running");

        when(sneakerService.updateSneaker(eq(sneakerId), any(Sneaker.class))).thenReturn(updatedSneaker);

        ResponseEntity<Sneaker> response = sneakerController.updateSneaker(sneakerId, updatedSneaker);

        assertNotNull(response);
        assertEquals(OK, response.getStatusCode());
        assertEquals(updatedSneaker, response.getBody());
    }

    @Test
    public void testUpdateSneaker_NotFound() {
        int sneakerId = 1;
        Sneaker updatedSneaker = new Sneaker(sneakerId, "Adidas", "UltraBoost", "43", "A comfortable running shoe", "Running");

        when(sneakerService.updateSneaker(eq(sneakerId), any(Sneaker.class))).thenReturn(null);

        ResponseEntity<Sneaker> response = sneakerController.updateSneaker(sneakerId, updatedSneaker);

        assertNotNull(response);
        assertEquals(NOT_FOUND, response.getStatusCode());
    }
}