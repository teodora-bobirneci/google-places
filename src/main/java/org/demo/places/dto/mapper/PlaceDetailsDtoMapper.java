package org.demo.places.dto.mapper;

import com.google.common.base.Joiner;
import org.demo.places.dto.PhotoDto;
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
        details.setPhotoReferences(Joiner.on(",").join(dto.getPhotos().stream().map(PhotoDto::getPhoto_reference).collect(toList())));
        details.setPlace(place);
        details.setReference(dto.getReference());
        details.setUrl(dto.getUrl());
        details.setVicinity(dto.getVicinity());
        details.setWebsite(dto.getWebsite());

        return details;
    }

}
