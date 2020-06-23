package org.demo.places.dto;

import lombok.Getter;

@Getter
public class PlaceDto {
    private String id;
    private String place_id;
    private String name;
    private String icon;
    private GeometryDto geometry;
}
