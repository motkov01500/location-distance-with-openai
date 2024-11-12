package org.example;

import org.example.entity.Location;
import org.example.service.LocationService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        LocationService locationService = LocationService.getINSTANCE();

        locationService.getAllLocations().forEach(System.out::println);
    }
}