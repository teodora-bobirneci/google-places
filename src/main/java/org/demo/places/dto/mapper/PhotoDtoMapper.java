package org.demo.places.dto.mapper;

import com.google.common.base.Joiner;
import org.demo.places.dto.PhotoDto;
import org.demo.places.model.PhotoReference;
import org.demo.places.model.PlaceDetails;

public class PhotoDtoMapper {
    public static PhotoReference fromDto(PhotoDto dto, PlaceDetails placeDetails) {
        PhotoReference ref = new PhotoReference();
        ref.setPlaceDetails(placeDetails);
        ref.setReference(dto.getPhoto_reference());
        ref.setWidth(dto.getWidth());
        ref.setHeight(dto.getHeight());
        ref.setAttributions(Joiner.on(",").join(dto.getHtml_attributions()));
        return ref;
    }
}