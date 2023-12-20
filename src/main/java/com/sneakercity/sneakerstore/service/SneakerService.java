package com.sneakercity.sneakerstore.service;

import com.sneakercity.sneakerstore.model.Sneaker;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SneakerService {

    private final List<Sneaker> sneakerList = new ArrayList<>();

    // Random generator for the ID since we don't have a db yet

    private final Random random = new Random();


    // Return every sneaker / entry
    public List<Sneaker> getAllSneakers() {
        return new ArrayList<>(sneakerList);
    }

    // Return sneaker with specific id
    public Sneaker getSneakerById(int id) {
        for (Sneaker sneaker : sneakerList) {
            if (sneaker.getId() == id) {
                return sneaker;
            }
        }
        return null; // return null if no sneaker with the given id is found
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

    public boolean deleteSneaker(int id) {
        Iterator<Sneaker> iterator = sneakerList.iterator();
        while (iterator.hasNext()) {
            Sneaker sneaker = iterator.next();
            if (sneaker.getId() == id) {
                iterator.remove();
                return false;
            }
        }
        return false;
    }

    public List<Sneaker> filterSneakers(String brand, String color, Double minPrice, Double maxPrice, Integer size) {
    return null;
    }

    public List<Sneaker> getSneakersByBrand(String brand) {
        return null;
    }


    public List<Sneaker> addMultipleSneakers(List<Sneaker> sneakers) {
        return null;
    }

    public List<Sneaker> getLatestSneakers(Integer limit) {
        return null;
    }
}
