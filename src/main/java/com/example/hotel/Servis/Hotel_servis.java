package com.example.hotel.Servis;

import com.example.hotel.model.Hotel;
import com.example.hotel.repository.Hotel_repozitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Hotel_servis {
    @Autowired
    Hotel_repozitory hotel_repozitory;
    public String hotel_qoshish(Hotel hotel){
        boolean holat=hotel_repozitory.existsByNomi(hotel.getNomi());
        if(holat){
            return "Bundan mexmonxona mavjud !!!";
        }
        Hotel hotel1=new Hotel();

        hotel1.setNomi(hotel.getNomi());
        hotel_repozitory.save(hotel1);
        return "Ma`lumot joylandi";
    }
public List<Hotel> hotels(){
        List<Hotel> hotelList=hotel_repozitory.findAll();
        return hotelList;
}
public String yangilash(Integer id, Hotel hotel){
    Optional<Hotel> optionalHotel=hotel_repozitory.findById(id);
    if (optionalHotel.isPresent()){
        Hotel hotel1=new Hotel();
        hotel1.setNomi(hotel.getNomi());
        hotel_repozitory.save(hotel1);
        return "Ma`lumot o`zgartirildi";
    }
    return "Bunday mexmonxona mavjud emas !!!";
}
public String ochirish(Integer id){
        Optional<Hotel> optionalHotel=hotel_repozitory.findById(id);
        if (optionalHotel.isPresent()){
            hotel_repozitory.deleteById(id);
            return "Ma'lumot o`chirildi";
        }
        return "Bunday mexmonxona mavjud emas";
}
}
