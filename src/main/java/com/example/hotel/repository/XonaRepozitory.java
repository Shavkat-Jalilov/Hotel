package com.example.hotel.repository;

import com.example.hotel.model.Xona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface XonaRepozitory extends JpaRepository<Xona, Integer> {
    boolean existsByRaqamiAndQavatiAndHotel_Id(String raqami, Integer qavati, Integer hotel_id);
    List<Xona> findAllByHotel_Id(Integer id);
}
