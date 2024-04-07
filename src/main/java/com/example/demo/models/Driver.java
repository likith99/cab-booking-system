// Driver.java
package com.example.demo.models;

import com.example.demo.enums.RideStatus;

public class Driver {
    private String name;
    private String gender;
    private int age;
    private String vehicleDetails;
    private String vehicleNumber;
    private int[] currentLocation;
    private RideStatus status;

    public Driver(String name, String gender, int age, String vehicleDetails, String vehicleNumber, int[] currentLocation) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.vehicleDetails = vehicleDetails;
        this.vehicleNumber = vehicleNumber;
        this.currentLocation = currentLocation;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(String vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public int[] getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(int[] currentLocation) {
        this.currentLocation = currentLocation;
    }
    public RideStatus getStatus() {
        return status;
    }
    public void setStatus(RideStatus status) {
        this.status = status;
    }
}
