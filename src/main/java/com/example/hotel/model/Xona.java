package com.example.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class Xona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private  String raqami;
    @Column(nullable = false)
    private  Integer qavati;
    @Column(nullable = false)
    private  Integer XonaIchidagiXona;

    @ManyToOne
    Hotel hotel;
}
