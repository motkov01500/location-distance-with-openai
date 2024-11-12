package org.example.service;

import org.example.entity.Location;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class LocationService extends CrudService<Location> {

    private static LocationService INSTANCE;

    public LocationService() {
        super(Location.class);
    }

    public static LocationService getINSTANCE() {
        if(INSTANCE == null) {
            INSTANCE = new LocationService();
        }
        return INSTANCE;
    }

    public List<Location> getAllLocations() {
        CriteriaBuilder cb = getCriteriaBuilder();
        CriteriaQuery<Location> query = getCriteriaQuery();
        Root<Location> locationRoot = query.from(Location.class);
        query.select(locationRoot);
        return getEntityManager().createQuery(query).getResultList();
    }
}
