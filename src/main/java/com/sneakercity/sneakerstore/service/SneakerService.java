package com.sneakercity.sneakerstore.service;

import com.sneakercity.sneakerstore.model.Sneaker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class SneakerService {

    private final List<Sneaker> sneakerList = new ArrayList<>();

    // Random generator for the ID since we don't have a db yet

    private final Random random = new Random();


    // Return every sneaker / entry
    public List<Sneaker> getAllSneakers() {
        return new ArrayList<>(sneakerList);
    }

    // add 1 sneaker
    public Sneaker addSneaker(Sneaker sneaker) {
        int randomId = random.nextInt(Integer.MAX_VALUE);
        sneaker.setId(randomId);
        sneakerList.add(sneaker); // Add transaction to the list, not calling on the transaction object
        return sneaker;
    }

    public Sneaker updateSneaker(int id, Sneaker updatedSneaker) {
        for (Sneaker sneaker : sneakerList) {
            if (sneaker.getId() == id) {
                sneaker.setMerk(updatedSneaker.getMerk());
                sneaker.setSchoennaam(updatedSneaker.getSchoennaam());
                sneaker.setSchoenmaat(updatedSneaker.getSchoenmaat());
                sneaker.setBeschrijving(updatedSneaker.getBeschrijving());
                sneaker.setCategorie(updatedSneaker.getCategorie());
                return sneaker;
            }
        }
        return null;
    }
}
