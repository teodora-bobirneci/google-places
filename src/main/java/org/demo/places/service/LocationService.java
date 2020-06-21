package org.demo.places.service;

import org.demo.places.model.City;
import org.demo.places.model.Place;

import java.util.List;

public interface LocationService {
    City save(City city);

    City getCity(Long id);

    List<City> getCities();

    void deleteAllCities();

    List<Place> getPlaces(City city);

    Place save(Place place);

    void deleteAllPlaces();
}
