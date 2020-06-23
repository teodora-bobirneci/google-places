package org.demo.places.google;

import org.demo.places.dto.DetailsSearchResult;
import org.demo.places.dto.NearbySearchResult;
import org.demo.places.dto.PlaceDetailsDto;
import org.demo.places.dto.PlaceDto;
import org.demo.places.dto.mapper.PlaceDetailsDtoMapper;
import org.demo.places.dto.mapper.PlaceDtoMapper;
import org.demo.places.model.City;
import org.demo.places.model.Place;
import org.demo.places.model.PlaceDetails;
import org.demo.places.service.HttpInvoker;
import org.demo.places.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class GooglePlacesComponentImpl implements GooglePlacesComponent {
    private static final Integer DEFAULT_RADIUS = 5000;

    private HttpInvoker httpInvoker;
    private LocationService locationService;

    @Override public List<Place> fetchPlaces(City city) {
        String uri = GooglePlacesUri.nearbySearchUriBuilder().outputType("json")
                .latitude(city.getLatitude()).longitude(city.getLongitude())
                .radius(DEFAULT_RADIUS)
                .build();
        return (new ArrayList<>(httpInvoker.get(uri, NearbySearchResult.class).getResults())).stream()
                .map((PlaceDto dto) -> PlaceDtoMapper.fromDto(dto, city)).collect(toList());
    }

    @Override public PlaceDetails fetchDetails(Place place) {
        String uri = GooglePlacesUri.placeDetailsUriBuilder().outputType("json")
                .placeId(place.getGooglePlaceId())
                .build();
        PlaceDetailsDto result = httpInvoker.get(uri, DetailsSearchResult.class).getResult();
        PlaceDetails placeDetails = PlaceDetailsDtoMapper.fromDto(result, place);
        return locationService.save(placeDetails);
    }

    @Autowired public void setHttpInvoker(HttpInvoker httpInvoker) {
        this.httpInvoker = httpInvoker;
    }

    @Autowired public void setLocationService(LocationService locationService) {
        this.locationService = locationService;
    }

}
