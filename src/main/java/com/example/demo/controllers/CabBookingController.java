package com.example.demo.controllers;

import com.example.demo.dtos.RideDTO;
import com.example.demo.services.CabBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CabBookingController {
    private final CabBookingService cabBookingService;

    @Autowired
    public CabBookingController(CabBookingService cabBookingService) {
        this.cabBookingService = cabBookingService;
    }

    @PostMapping("/addUser")
    public void addUser(@RequestParam String name, @RequestParam String gender, @RequestParam int age) {
        cabBookingService.addUser(name, gender, age);
    }

    @PostMapping("/addDriver")
    public void addDriver(@RequestParam String name, @RequestParam String gender, @RequestParam int age,
                          @RequestParam String vehicleDetails, @RequestParam String vehicleNumber,
                          @RequestParam int[] currentLocation) {
        cabBookingService.addDriver(name, gender, age, vehicleDetails, vehicleNumber, currentLocation);
    }

    @PostMapping("/findRide")
    public List<RideDTO> findRide(@RequestParam String username, @RequestParam int[] source, @RequestParam int[] destination) {
        return cabBookingService.findRide(username, source, destination);
    }




    @PostMapping("/chooseRide")
    public String chooseRide(@RequestParam String username, @RequestParam String driverName) {
        return cabBookingService.chooseRide(username, driverName);
    }
}
