package com.sneakercity.sneakerstore.service;

import com.sneakercity.sneakerstore.model.Sneaker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SneakerService {

    private final List<Sneaker> sneakerList = new ArrayList<>();

    // Return every sneaker / entry
    public List<Sneaker> getAllSneakers() {
         return new ArrayList<>(sneakerList);
    }



}
