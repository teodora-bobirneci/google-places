package org.demo.places.dto;

import lombok.Getter;

import java.util.List;

public class NearbySearchResult {
    @Getter private List<PlaceDto> results;

    public String toString() {return "NearbySearchResult(results=" + this.getResults() + ")";}
}
