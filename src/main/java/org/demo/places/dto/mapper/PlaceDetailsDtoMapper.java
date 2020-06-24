package org.demo.places.dto.mapper;

import org.demo.places.dto.PlaceDetailsDto;
import org.demo.places.model.Place;
import org.demo.places.model.PlaceDetails;

import static java.util.stream.Collectors.toList;

public class PlaceDetailsDtoMapper {

    public static PlaceDetails fromDto(PlaceDetailsDto dto, Place place) {
        PlaceDetails details = new PlaceDetails();
        details.setGoogleInternalId(dto.getId());
        details.setName(dto.getName());
        details.setFormattedAddress(dto.getFormatted_address());
        details.setPhotoReferences(dto.getPhotos().stream().map(pr -> PhotoDtoMapper.fromDto(pr, details)).collect(toList()));
        details.setPlace(place);
        details.setReference(dto.getReference());
        details.setUrl(dto.getUrl());
        details.setVicinity(dto.getVicinity());
        details.setWebsite(dto.getWebsite());

        return details;
    }

}
