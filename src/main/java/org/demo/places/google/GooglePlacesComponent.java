package org.demo.places.google;

import org.demo.places.model.City;
import org.demo.places.model.Place;
import org.demo.places.model.PlaceDetails;

import java.util.List;

public interface GooglePlacesComponent {

    List<Place> fetchPlaces(City city);

    PlaceDetails fetchDetails(Place place);

}
