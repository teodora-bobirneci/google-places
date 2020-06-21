package org.demo.places.google;

import org.demo.places.Application;
import org.demo.places.model.City;
import org.demo.places.model.Place;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = Application.class)
public class GooglePlacesComponentShould {

    @Autowired private GooglePlacesComponent googlePlacesComponent;

    @Test public void successfully_invoke_the_nearby_search_operation() {
        List<Place> beautifulPlaces = googlePlacesComponent.fetchPlaces(new City("Iasi", 47.1584563, 27.601446));

        assertThat(beautifulPlaces).isNotEmpty();
    }

}