package com.sneakercity.sneakerstore.controller;

// import statements...

import org.junit.jupiter.api.Test;

import static org.h2.store.fs.FilePath.get;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class SneakerControllerTest {

    @Mock
    private SneakerService sneakerService;

    @InjectMocks
    private SneakerController sneakerController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    private UUID testId;
    private Sneaker testSneaker;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(sneakerController).build();
        objectMapper = new ObjectMapper();
        testId = UUID.randomUUID();
        testSneaker = new Sneaker();
        // initialize other fields of testSneaker as necessary
    }

    @Test
    public void testGetAllSneakers() throws Exception {
        List<Sneaker> sneakers = Arrays.asList(new Sneaker(), new Sneaker());
        when(sneakerService.getAllSneakers()).thenReturn(sneakers);

        mockMvc.perform(get("/api/sneakers"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(sneakers)));
    }

    @Test
    public void testGetASneaker() throws Exception {
        when(sneakerService.getSneakerById(testId)).thenReturn(Optional.of(testSneaker));

        mockMvc.perform(get("/api/sneakers/" + testId.toString()))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(testSneaker)));
    }

    @Test
    public void testAddSneaker() throws Exception {
        when(sneakerService.addSneaker(any(Sneaker.class))).thenReturn(testSneaker);

        mockMvc.perform(post("/api/sneakers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testSneaker)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(testSneaker)));
    }

    @Test
    public void testAddMultipleSneakers() throws Exception {
        List<Sneaker> sneakers = Arrays.asList(new Sneaker(), new Sneaker());
        when(sneakerService.addMultipleSneakers(anyList())).thenReturn(sneakers);

        mockMvc.perform(post("/api/sneakers/bulk")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(sneakers)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(sneakers)));
    }

    @Test
    public void testUpdateSneaker() throws Exception {
        when(sneakerService.updateSneaker(eq(testId), any(Sneaker.class))).thenReturn(Optional.of(testSneaker));

        mockMvc.perform(put("/api/sneakers/" + testId.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testSneaker)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(testSneaker)));
    }

    @Test
    public void testDeleteSneaker() throws Exception {
        when(sneakerService.deleteSneaker(testId)).thenReturn(true);

        mockMvc.perform(delete("/api/sneakers/" + testId.toString()))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Sneaker deleted successfully.")));
    }

    @Test
    public void testFilterSneakers() throws Exception {
        List<Sneaker> filteredSneakers = Arrays.asList(new Sneaker(), new Sneaker());
        when(sneakerService.filterSneakers(anyString(), anyString(), anyDouble(), anyDouble(), anyInt()))
                .thenReturn(filteredSneakers);

        mockMvc.perform(get("/api/sneakers/filter")
                        .param("brand", "Nike")
                        .param("color", "Red")
                        .param("minPrice", "100.0")
                        .param("maxPrice", "200.0")
                        .param("size", "9"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(filteredSneakers)));
    }

    @Test
    public void testGetSneakersByBrand() throws Exception {
        List<Sneaker> brandSneakers = Arrays.asList(new Sneaker(), new Sneaker());
        when(sneakerService.getSneakersByBrand("Nike")).thenReturn(brandSneakers);

        mockMvc.perform(get("/api/sneakers/brand/Nike"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(brandSneakers)));
    }

    // Add tests for any other methods in SneakerController
 @Test
    void test2(){


        // added more as necessary
 }
}
