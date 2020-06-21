package org.demo.places.service;

import org.demo.places.dao.CityRepository;
import org.demo.places.dao.PlaceRepository;
import org.demo.places.model.City;
import org.demo.places.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;

@Service
public class DefaultLocationService implements LocationService {

    private PlaceRepository placeRepository;
    private CityRepository cityRepository;

    @Override public City save(City city) {
        return cityRepository.save(city);
    }

    @Override public City getCity(Long id) {
        return cityRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(String.format("A city with id %d does not exist", id)));
    }

    @Override public Place save(Place place) {
        return placeRepository.save(place);
    }

    @Override public List<Place> getPlaces(City city) {
        return new ArrayList<>(placeRepository.findPlacesIn(city));
    }

    @Override public List<City> getCities() {
        return stream(cityRepository.findAll().spliterator(), false)
                .sorted(comparing(City::getName))
                .collect(toList());
    }

    @Override public void deleteAllCities() {
        cityRepository.deleteAll();
    }

    @Override public void deleteAllPlaces() {
        placeRepository.deleteAll();
    }

    @Autowired public void setPlaceRepository(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Autowired public void setCityRepository(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
}
