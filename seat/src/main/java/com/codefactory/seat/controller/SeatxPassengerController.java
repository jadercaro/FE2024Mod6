package com.codefactory.seat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codefactory.seat.model.SeatxPassenger;
import com.codefactory.seat.service.ISeat;
import com.codefactory.seat.service.ISeatxPassenger;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/seatPassenger")
public class SeatxPassengerController {

    @Autowired
    ISeatxPassenger seatxPassenger;

    @Autowired
    ISeat seatService;

    @RequestMapping(value = "/generateSeatPassenger", method = RequestMethod.POST)
    Iterable<SeatxPassenger> generateSeatxPassenger(){
        return seatxPassenger.createSeatxPassenger();
    }

    @RequestMapping(value = "/setSeat", method=RequestMethod.POST)
    public String AssingSeat(@RequestParam String passenger, 
                            @RequestParam String seat) {
        seatService.unavaibleSeat(Long.parseLong(seat));
        return seatxPassenger.assingSeat(Long.parseLong(passenger), Long.parseLong(seat));
        
        
    }
    
}
