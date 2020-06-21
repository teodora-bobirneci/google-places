package org.demo.places.dto;

import lombok.Getter;

@Getter
public class PlaceDto {
    private String id;
    private String name;
    private String icon;
    private GeometryDto geometry;
}
