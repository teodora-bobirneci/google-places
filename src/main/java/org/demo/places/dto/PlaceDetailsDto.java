package org.demo.places.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class PlaceDetailsDto {
    private String id;
    private String name;
    private String formatted_address;
    private GeometryDto geometry;
    private String icon;
    private List<PhotoDto> photos;
    private String place_id;
    private String reference;
    private String scope;
    private String url;
    private String vicinity;
    private String website;
}
