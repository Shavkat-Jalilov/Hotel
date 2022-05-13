package com.example.hotel.Controller;

import com.example.hotel.Servis.Hotel_servis;
import com.example.hotel.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Mexmonxona")
public class HotelController {
    @Autowired
    Hotel_servis hotel_servis;
    @PostMapping("/kiritish")
    public String Xotel_cread(@RequestBody Hotel hotel){
        return hotel_servis.hotel_qoshish(hotel);
    }
    @GetMapping("/read")
    public List<Hotel> hotels(){
        return hotel_servis.hotels();
    }
    @PutMapping("/update/{id}")
    public  String yangilash(@PathVariable Integer id, @RequestBody Hotel hotel){
    return hotel_servis.yangilash(id, hotel);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        return hotel_servis.ochirish(id);
    }

}
