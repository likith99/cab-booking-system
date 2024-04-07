// RideDTO.java
package com.example.demo.dtos;

import com.example.demo.enums.RideStatus;

public class RideDTO {
    private String driverName;
    private RideStatus rideStatus;

    public RideDTO(String driverName, RideStatus rideStatus) {
        this.driverName = driverName;
        this.rideStatus = rideStatus;
    }

    // Getters and setters
    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }

    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }
}
