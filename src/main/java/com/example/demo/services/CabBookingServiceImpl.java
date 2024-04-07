package com.example.demo.services;

import com.example.demo.dtos.RideDTO;
import com.example.demo.enums.RideStatus;
import com.example.demo.exceptions.RideNotFoundException;
import com.example.demo.models.Driver;
import com.example.demo.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CabBookingServiceImpl implements CabBookingService {
    private Map<String, User> users = new HashMap<>();
    private Map<String, Driver> drivers = new HashMap<>();

    @Override
    public void addUser(String name, String gender, int age) {
        users.put(name, new User(name, gender, age));
    }

    @Override
    public void addDriver(String name, String gender, int age, String vehicleDetails, String vehicleNumber, int[] currentLocation) {
        drivers.put(name, new Driver(name, gender, age, vehicleDetails, vehicleNumber, currentLocation));
    }

    @Override
    public List<RideDTO> findRide(String username, int[] source, int[] destination) {
        List<RideDTO> availableRides = new ArrayList<>();
        for (Map.Entry<String, Driver> entry : drivers.entrySet()) {
            Driver driver = entry.getValue();
            double distanceToSource = distance(driver.getCurrentLocation(), source);
            double distanceToDestination = distance(driver.getCurrentLocation(), destination);
            if (distanceToSource <= 5 && distanceToDestination <= 5
                    && driver.getStatus() == RideStatus.AVAILABLE) {
                availableRides.add(new RideDTO(entry.getKey(), RideStatus.AVAILABLE));
            }
        }
        return availableRides;
    }



    @Override
    public String chooseRide(String username, String driverName) {
        if (drivers.containsKey(driverName) && drivers.get(driverName).getStatus() == RideStatus.AVAILABLE) {
            drivers.get(driverName).setStatus(RideStatus.BUSY);
            return driverName;
        } else {
            throw new RideNotFoundException("Driver not found or not available");
        }
    }

    private double distance(int[] location1, int[] location2) {
        return Math.sqrt(Math.pow(location1[0] - location2[0], 2) + Math.pow(location1[1] - location2[1], 2));
    }

}
