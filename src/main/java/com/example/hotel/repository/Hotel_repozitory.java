package com.example.hotel.repository;

import com.example.hotel.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Hotel_repozitory extends JpaRepository<Hotel, Integer> {
    boolean existsByNomi(String nomi);
}
