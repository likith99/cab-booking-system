// CabBookingService.java
package com.example.demo.services;

import com.example.demo.dtos.RideDTO;

import java.util.List;

public interface CabBookingService {
    void addUser(String name, String gender, int age);

    void addDriver(String name, String gender, int age, String vehicleDetails, String vehicleNumber, int[] currentLocation);

    List<RideDTO> findRide(String username, int[] source, int[] destination);

    String chooseRide(String username, String driverName);
}
