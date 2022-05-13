package com.example.hotel.Controller;

import com.example.hotel.DTO.Hotel_dto;
import com.example.hotel.Servis.XonaServis;
import com.example.hotel.model.Xona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Xona")
public class XonaController{
    @Autowired
    XonaServis xonaServis;
    @PostMapping("/kiritish")
    public String create(@RequestBody Hotel_dto hotel_dto){
    return xonaServis.create(hotel_dto);
    }
    @GetMapping("/Xonalar")
    public List<Xona> xonalar(){
        return xonaServis.rooms();
    }
    @PutMapping("/ozgartirish/{id}")
    public String update(@PathVariable Integer id, @RequestBody Hotel_dto hotel_dto){
        return xonaServis.update(id, hotel_dto);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        return xonaServis.ochirish(id);
    }
}
