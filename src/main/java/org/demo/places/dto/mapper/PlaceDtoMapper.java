package org.demo.places.dto.mapper;

import org.demo.places.dto.PlaceDto;
import org.demo.places.model.City;
import org.demo.places.model.Place;

public class PlaceDtoMapper {
    public static Place fromDto(PlaceDto dto, City city){
        return new Place(dto.getPlace_id(), dto.getName(),dto.getIcon() , city);
    }
}
