package com.sneakercity.sneakerstore.repository;


import com.sneakercity.sneakerstore.model.Sneaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SneakerRepository extends JpaRepository<Sneaker, UUID> {
}
