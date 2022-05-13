package com.example.hotel.Servis;

import com.example.hotel.DTO.Hotel_dto;
import com.example.hotel.model.Hotel;
import com.example.hotel.model.Xona;
import com.example.hotel.repository.Hotel_repozitory;
import com.example.hotel.repository.XonaRepozitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.synth.SynthTreeUI;
import java.util.List;
import java.util.Optional;

@Service
public class XonaServis {
    @Autowired
    XonaRepozitory xonaRepozitory;
    @Autowired
    Hotel_repozitory hotel_repozitory;
    public String create(Hotel_dto hotel_dto){
       if(!xonaRepozitory.existsByRaqamiAndQavatiAndHotel_Id(hotel_dto.getRaqami(), hotel_dto.getQavati(), hotel_dto.getHotelId())){
           Optional<Hotel> optional = hotel_repozitory.findById(hotel_dto.getHotelId());
           if(!optional.isPresent()){
               return "Bunday mexmonxona mavjud";
           }
           Xona xona=new Xona();
           xona.setRaqami(hotel_dto.getRaqami());
           xona.setQavati(hotel_dto.getQavati());
           xona.setXonaIchidagiXona(hotel_dto.getXonaIchidagiXona());
           xona.setHotel(optional.get());
           xonaRepozitory.save(xona);
           return "Ma`lumotlar saqlandi";
       }
        return "Ma`lumotlar saqlanmadi bunday xona mavjud";
    }
    public List<Xona> rooms(){
        List<Xona> roomList=xonaRepozitory.findAll();
        return  roomList;
    }
    public String update(Integer id, Hotel_dto hotel_dto){
        Optional<Xona> optionalXona=xonaRepozitory.findById(id);
        if (!optionalXona.isPresent())
            return "Bunday xona mavjud emas !!!";
        if(!xonaRepozitory.existsByRaqamiAndQavatiAndHotel_Id(hotel_dto.getRaqami(), hotel_dto.getQavati(), hotel_dto.getHotelId())){
            Optional<Hotel> optionalHotel1=hotel_repozitory.findById(hotel_dto.getHotelId());
            if(!optionalHotel1.isPresent()){
                return "Bnday mexmonxona mavjud emas !!!";
            }
            Xona xona=new Xona();
            xona.setRaqami(hotel_dto.getRaqami());
            xona.setQavati(hotel_dto.getQavati());
            xona.setXonaIchidagiXona(hotel_dto.getXonaIchidagiXona());
            xona.setHotel(optionalHotel1.get());
            xonaRepozitory.save(xona);
            return "Yangilandi";
        }
        return "Bunday xona mavjud !!!";
    }
    public String ochirish(Integer id){
        Optional<Xona> optionalXona=xonaRepozitory.findById(id);
        if (optionalXona.isPresent()){
            xonaRepozitory.deleteById(id);
            return "Ma`lumotlar o`chirildi";
        }
        return "Munday xona mavjud emas";
    }
}
