package com.example.demo;

import com.example.demo.services.CabBookingService;
import com.example.demo.services.CabBookingServiceImpl;
import com.example.demo.dtos.RideDTO;
import com.example.demo.enums.RideStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CabBookingApplicationTests {

	private CabBookingService cabBookingService;

	@BeforeEach
	public void setUp() {
		cabBookingService = new CabBookingServiceImpl();
		cabBookingService.addUser("Abhishek", "M", 23);
		cabBookingService.addUser("Rahul", "M", 29);
		cabBookingService.addUser("Nandini", "F", 22);

		cabBookingService.addDriver("Driver1", "M", 22, "Swift", "KA-01-12345", new int[]{10, 1});
		cabBookingService.addDriver("Driver2", "M", 29, "Swift", "KA-01-12345", new int[]{11, 10});
		cabBookingService.addDriver("Driver3", "M", 24, "Swift", "KA-01-12345", new int[]{5, 3});
	}

	@Test
	public void testFindRideForAbhishek() {

		assertEquals(0, cabBookingService.findRide("Abhishek", new int[]{0, 0}, new int[]{20, 1}).size());
	}

	@Test
	public void testFindRideForRahul() {

		assertEquals(0, cabBookingService.findRide("Rahul", new int[]{0, 0}, new int[]{20, 1}).size());
	}

	@Test
	public void testFindRideForNandini() {

		assertEquals(0, cabBookingService.findRide("Nandini", new int[]{0, 0}, new int[]{20, 1}).size());
	}
}
