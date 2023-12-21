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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
 class SneakerControllerTest {

    private MockMvc mockMvc;

    @Mock
    private SneakerService sneakerService;

    private Sneaker sneaker;

    @InjectMocks
    private SneakerController sneakerController;

    private List<Sneaker> mockSneakers;

    @BeforeEach
    void setUp() {
        mockMvc = standaloneSetup(sneakerController).build();
        // Create mock Sneaker objects
        Sneaker sneaker1 = new Sneaker(1, "Nike", "Air Max", "42", "Comfortable running shoe", "Running");
        Sneaker sneaker2 = new Sneaker(2, "Adidas", "Ultra Boost", "43", "High performance sports shoe", "Sports");

        mockSneakers = Arrays.asList(sneaker1, sneaker2);
        when(sneakerService.getAllSneakers()).thenReturn(mockSneakers);
        sneaker = new Sneaker(1, "Nike", "AirMax", "42", "Description", "Sports");
        sneakerService.addSneaker(sneaker);
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

//    @Test
//     void should_addSneakerTest() {
//        Sneaker newSneaker = new Sneaker(0, "New Balance", "574", "44", "Classic model", "Casual");
//        when(sneakerService.addSneaker(any(Sneaker.class))).thenReturn(newSneaker);
//
//        Sneaker addedSneaker = sneakerController.addSneaker(newSneaker);
//        assertNotNull(addedSneaker);
//        assertEquals("New Balance", addedSneaker.getMerk());
//        assertEquals("574", addedSneaker.getSchoennaam());
//
//        verify(sneakerService, times(1)).addSneaker(any(Sneaker.class));
//    }

    @Test
     void addSneakerInvalidInputTest() {
        when(sneakerService.addSneaker(null)).thenThrow(new IllegalArgumentException("Invalid sneaker"));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sneakerController.addSneaker(null);
        });

        assertEquals("Invalid sneaker", exception.getMessage());
    }

    @Test
     void testUpdateSneaker_Success() {
        int sneakerId = 1;
        Sneaker updatedSneaker = new Sneaker(sneakerId, "Adidas", "UltraBoost", "43", "A comfortable running shoe", "Running");

        when(sneakerService.updateSneaker(eq(sneakerId), any(Sneaker.class))).thenReturn(updatedSneaker);

        ResponseEntity<Sneaker> response = sneakerController.updateSneaker(sneakerId, updatedSneaker);

        assertNotNull(response);
        assertEquals(OK, response.getStatusCode());
        assertEquals(updatedSneaker, response.getBody());
    }

    @Test
     void testUpdateSneaker_NotFound() {
        int sneakerId = 1;
        Sneaker updatedSneaker = new Sneaker(sneakerId, "Adidas", "UltraBoost", "43", "A comfortable running shoe", "Running");

        when(sneakerService.updateSneaker(eq(sneakerId), any(Sneaker.class))).thenReturn(null);

        ResponseEntity<Sneaker> response = sneakerController.updateSneaker(sneakerId, updatedSneaker);

        assertNotNull(response);
        assertEquals(NOT_FOUND, response.getStatusCode());
    }

    @Test
    void shouldAddMultipleSneakers() {
        Sneaker newSneaker = new Sneaker(0, "New Balance", "574", "44", "Classic model", "Casual");
        Sneaker newSneaker2 = new Sneaker(1, "New Balance", "574", "44", "Classic model", "Casual");
        Sneaker newSneaker3 = new Sneaker(2, "New Balance", "974", "44", "Classic model", "Casual");

        when(sneakerService.addSneaker(any(Sneaker.class))).thenReturn(sneaker);


    }
//    @Test
//    void shouldGetASneaker() {
//
//        Sneaker newSneaker = new Sneaker(0, "New Balance", "574", "44", "Classic model", "Casual");
//        when(sneakerService.addSneaker(any(Sneaker.class))).thenReturn(newSneaker);
//
//        Sneaker addedSneaker = sneakerController.addSneaker(newSneaker);
//        assertNotNull(addedSneaker);
//        assertEquals("New Balance", addedSneaker.getMerk());
//        assertEquals("574", addedSneaker.getSchoennaam());
//
//        verify(sneakerService, times(1)).addSneaker(any(Sneaker.class));
//    }

    @Test
    void shouldDeleteASneaker() {
        // Arrange
        int id = 1;
        when(sneakerService.deleteSneaker(id)).thenReturn(true);

        // Act
        ResponseEntity<?> response = sneakerController.deleteSneaker(id);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Sneaker deleted successfully.", response.getBody());
        verify(sneakerService).deleteSneaker(id);
    }

    @Test
    public void testDeleteSneaker_NotFound() {
        // Arrange
        int id = 2;
        when(sneakerService.deleteSneaker(id)).thenReturn(false);

        // Act
        ResponseEntity<?> response = sneakerController.deleteSneaker(id);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Sneaker not found with ID: " + id, response.getBody());
        verify(sneakerService).deleteSneaker(id);
    }

    @Test
    public void testGetASneaker() throws Exception {
        when(sneakerService.getSneakerById(1)).thenReturn(new Sneaker()); // Assuming Sneaker is a valid entity
        mockMvc.perform(get("/getASneaker?id=1"))
                .andExpect(status().isOk());
        verify(sneakerService).getSneakerById(1);
    }

    @Test
    public void testFilterSneakers() throws Exception {
        when(sneakerService.filterSneakers("Nike", "Red", 100.0, 200.0, 42))
                .thenReturn(Arrays.asList(new Sneaker(), new Sneaker()));
        mockMvc.perform(get("/filterSneakers")
                        .param("brand", "Nike")
                        .param("color", "Red")
                        .param("minPrice", "100.0")
                        .param("maxPrice", "200.0")
                        .param("size", "42"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetSneakersByBrand() throws Exception {
        when(sneakerService.getSneakersByBrand("Adidas")).thenReturn(Arrays.asList(new Sneaker()));
        mockMvc.perform(get("/sneakersByBrand/Adidas"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetLatestSneakers() throws Exception {
        when(sneakerService.getLatestSneakers(10)).thenReturn(Arrays.asList(new Sneaker(), new Sneaker()));
        mockMvc.perform(get("/latestSneakers").param("limit", "10"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetSneakersSortedByPrice() throws Exception {
        when(sneakerService.getSneakersSortedByPrice("asc")).thenReturn(Arrays.asList(new Sneaker()));
        mockMvc.perform(get("/sneakers/sortedByPrice").param("order", "asc"))
                .andExpect(status().isOk());
    }

    @Test
    public void testSearchSneakers() throws Exception {
        when(sneakerService.searchSneakers("Jordan")).thenReturn(Arrays.asList(new Sneaker()));
        mockMvc.perform(get("/sneakers/search").param("keyword", "Jordan"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetSneakersBySize() throws Exception {
        when(sneakerService.getSneakersBySize(42)).thenReturn(Arrays.asList(new Sneaker()));
        mockMvc.perform(get("/sneakers/bySize").param("size", "42"))
                .andExpect(status().isOk());
    }







}