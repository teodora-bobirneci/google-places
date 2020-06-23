package org.demo.places.google;

import org.demo.places.Application;
import org.demo.places.model.City;
import org.demo.places.model.Place;
import org.demo.places.model.PlaceDetails;
import org.demo.places.service.LocationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = Application.class) class GooglePlacesComponentShould {

    @Autowired private GooglePlacesComponent googlePlacesComponent;
    @Autowired private LocationService locationService;
    private City iasi;

    @BeforeEach void setup() {
        iasi = locationService.save(new City("Iasi", 47.1584563, 27.601446));
    }

    @Test void successfully_invoke_the_nearby_search_operation() {
        List<Place> beautifulPlaces = googlePlacesComponent.fetchPlaces(iasi);

        assertThat(beautifulPlaces).isNotEmpty();
    }

    @Test
    void successfully_invoke_the_details_operation() {
        Place palace_of_culture = locationService.save(new Place("ChIJEwF-0537ykARaRRgtshhtW4", "Palace of Culture", null, iasi));
        PlaceDetails palaceOfCulture = googlePlacesComponent.fetchDetails(palace_of_culture);

        assertThat(palaceOfCulture.getFormattedAddress()).isEqualTo("Piața Palat 1, Iași 700259, Romania");
    }
}