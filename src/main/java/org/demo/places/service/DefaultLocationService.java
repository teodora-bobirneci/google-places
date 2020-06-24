package org.demo.places.service;

import org.demo.places.dao.CityRepository;
import org.demo.places.dao.PlaceDetailsRepository;
import org.demo.places.dao.PlaceRepository;
import org.demo.places.google.GooglePlacesComponent;
import org.demo.places.model.City;
import org.demo.places.model.Place;
import org.demo.places.model.PlaceDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;
import static org.springframework.util.CollectionUtils.isEmpty;

@Service
public class DefaultLocationService implements LocationService {

    private PlaceRepository placeRepository;
    private PlaceDetailsRepository placeDetailsRepository;
    private CityRepository cityRepository;
    private GooglePlacesComponent googlePlacesComponent;

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
        List<Place> places = newArrayList(placeRepository.findPlacesIn(city));
        if (isEmpty(places)) {
            List<Place> newPlaces = googlePlacesComponent.fetchPlaces(city);
            places.addAll(stream(placeRepository.saveAll(newPlaces).spliterator(), false).collect(toList()));
        }
        return places;
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

    @Override public PlaceDetails getPlaceDetails(Long id) {
        Place place = placeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(String.format("There is no place with this id:%d", id)));
        Optional<PlaceDetails> dbDetails = placeDetailsRepository.findDetailsFor(place);
        if (dbDetails.isPresent()) {
            return dbDetails.get();
        }
        PlaceDetails fetchedDetails = googlePlacesComponent.fetchDetails(place);
        return placeDetailsRepository.save(fetchedDetails);
    }

    @Override public PlaceDetails save(PlaceDetails placeDetails) {
        return placeDetailsRepository.save(placeDetails);
    }

    @Autowired public void setPlaceRepository(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Autowired public void setPlaceDetailsRepository(PlaceDetailsRepository placeDetailsRepository) {
        this.placeDetailsRepository = placeDetailsRepository;
    }

    @Autowired public void setCityRepository(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Autowired public void setGooglePlacesComponent(GooglePlacesComponent googlePlacesComponent) {
        this.googlePlacesComponent = googlePlacesComponent;
    }
}
