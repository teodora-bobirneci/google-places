package org.demo.places.dto;

import lombok.Getter;

import java.util.List;

@Getter public class PhotoDto {
    private Integer width;
    private Integer height;
    private String photo_reference;
    private List<String> html_attributions;
}
