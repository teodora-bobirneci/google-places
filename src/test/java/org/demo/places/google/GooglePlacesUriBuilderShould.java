package org.demo.places.google;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class GooglePlacesUriBuilderShould {
    private final Double latitude = new Random().nextDouble();
    private final Double longitude = new Random().nextDouble();
    private final String placeId = RandomStringUtils.randomAlphanumeric(50);
    private final String apiKey = RandomStringUtils.randomAlphanumeric(100);

    @Test void correctly_build_nearby_search_url() {
        String nearbySearchUri = GooglePlacesUri.nearbySearchUriBuilder().outputType("xml").latitude(latitude).longitude(longitude).radius(3000).apiKey(apiKey).build();

        assertThat(nearbySearchUri).isEqualTo("https://maps.googleapis.com/maps/api/place/nearbysearch/xml?location=" + latitude + "," + longitude + "&radius=3000&key=" + apiKey);
    }

    @Test void correctly_build_place_details_url() {
        String detailsUri = GooglePlacesUri.placeDetailsUriBuilder().outputType("xml").placeId(placeId).apiKey(apiKey).build();

        assertThat(detailsUri).isEqualTo("https://maps.googleapis.com/maps/api/place/details/xml?place_id=" + placeId + "&key=" + apiKey);
    }

}
