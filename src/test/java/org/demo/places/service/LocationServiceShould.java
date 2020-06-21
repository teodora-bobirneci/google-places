package org.demo.places.service;

import org.demo.places.model.City;
import org.demo.places.model.Place;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class LocationServiceShould {
    @Autowired private DefaultLocationService locationService;
    private City iasi;
    private City cluj;
    private City zalau;

    @BeforeEach
    public void setup() {
        locationService.deleteAllCities();
        locationService.deleteAllPlaces();

        iasi = locationService.save(new City("Iasi"));
        zalau = locationService.save(new City("Zalau"));
        cluj = locationService.save(new City("Cluj"));
    }

    @Test public void retrieve_cities_sorted_alphabetically() {
        List<City> cities = locationService.getCities();

        assertThat(cities.get(0)).isEqualTo(cluj);
        assertThat(cities.get(1)).isEqualTo(iasi);
        assertThat(cities.get(2)).isEqualTo(zalau);
    }

    @Test public void return_places_based_on_city() {
        Place palaceOfCulture = locationService.save(new Place("Palace of Culture", iasi));
        Place formSpace = locationService.save(new Place("Form Space", cluj));

        assertThat(locationService.getPlaces(iasi)).containsOnly(palaceOfCulture);
        assertThat(locationService.getPlaces(cluj)).containsOnly(formSpace);
    }

}
