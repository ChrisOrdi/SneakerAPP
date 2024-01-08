package com.sneakercity.sneakerstore.service;

import com.sneakercity.sneakerstore.model.Sneaker;
import com.sneakercity.sneakerstore.repository.SneakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SneakerService {

    private final SneakerRepository sneakerRepository;

    @Autowired
    public SneakerService(SneakerRepository sneakerRepository) {
        this.sneakerRepository = sneakerRepository;
    }

    private final List<Sneaker> sneakerList = new ArrayList<>();

    // Random generator for the ID since we don't have a db yet

    private final Random random = new Random();


    // Return every sneaker / entry
    public List<Sneaker> getAllSneakers() {
        return sneakerRepository.findAll();
    }

    // Return sneaker with specific id
    public Optional<Sneaker> getSneakerById(UUID id) {
        return sneakerRepository.findById(id);
    }

    // Add 1 sneaker
    public Sneaker addSneaker(Sneaker sneaker) {
        return sneakerRepository.save(sneaker);
    }

    // Update 1 sneaker
    public Optional<Sneaker> updateSneaker(UUID id, Sneaker updatedSneaker) {
        return sneakerRepository.findById(id)
                .map(sneaker -> {
                    sneaker.setMerk(updatedSneaker.getMerk());
                    sneaker.setSchoennaam(updatedSneaker.getSchoennaam());
                    sneaker.setSchoenmaat(updatedSneaker.getSchoenmaat());
                    sneaker.setBeschrijving(updatedSneaker.getBeschrijving());
                    sneaker.setCategorie(updatedSneaker.getCategorie());
                    sneaker.setPrice(updatedSneaker.getPrice());
                    sneaker.setColor(updatedSneaker.getColor());
                    return sneakerRepository.save(sneaker);
                });
    }

    // Delete 1 sneaker
    public boolean deleteSneaker(UUID id) {
        if (sneakerRepository.existsById(id)) {
            sneakerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Add multiple sneakers
    public List<Sneaker> addMultipleSneakers(List<Sneaker> sneakers) {
        return sneakerRepository.saveAll(sneakers);
    }

    public List<Sneaker> filterSneakers(String brand, String color, Double minPrice, Double maxPrice, Integer size) {
        return sneakerList.stream()
                .filter(sneaker -> (brand == null || sneaker.getMerk().equalsIgnoreCase(brand)) &&
                        (color == null || sneaker.getColor().equalsIgnoreCase(color)) &&
                        (minPrice == null || sneaker.getPrice() >= minPrice) &&
                        (maxPrice == null || sneaker.getPrice() <= maxPrice) &&
                        (size == null || sneaker.getSchoenmaat().equals(size.toString())))
                .collect(Collectors.toList());
    }
    /*

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



    public List<Sneaker> getSneakersByBrand(String brand) {
        return null;
    }


    public List<Sneaker> addMultipleSneakers(List<Sneaker> sneakers) {
        for (Sneaker sneaker : sneakers) {
            addSneaker(sneaker); // Reuse the addSneaker method
        }
        return sneakers;
    }

    public List<Sneaker> getLatestSneakers(Integer limit) {
        return sneakerList.stream()
                .sorted(Comparator.comparingInt(Sneaker::getId).reversed()) // Assuming higher IDs are newer
                .limit(limit != null ? limit : sneakerList.size())
                .collect(Collectors.toList());
    }

    public List<Sneaker> getSneakersSortedByPrice(String order) {
        // Assuming you add a price property to Sneaker class
        return sneakerList.stream()
                .sorted(order.equalsIgnoreCase("desc") ?
                        Comparator.comparingDouble(Sneaker::getPrice).reversed() :
                        Comparator.comparingDouble(Sneaker::getPrice))
                .collect(Collectors.toList());
    }

    public List<Sneaker> searchSneakers(String keyword) {
        return sneakerList.stream()
                .filter(sneaker -> sneaker.getMerk().contains(keyword) ||
                        sneaker.getSchoennaam().contains(keyword) ||
                        sneaker.getBeschrijving().contains(keyword))
                .collect(Collectors.toList());
    }

    public List<Sneaker> getSneakersBySize(int size) {
        return sneakerList.stream()
                .filter(sneaker -> sneaker.getSchoenmaat().equals(String.valueOf(size)))
                .collect(Collectors.toList());
    }
    */


}
