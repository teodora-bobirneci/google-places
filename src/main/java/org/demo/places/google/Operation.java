package org.demo.places.google;

public enum Operation {
    NEARBY_SEARCH("/nearbysearch"),
    DETAILS("/details"),
    PHOTO("/photo");


    private final String identifier;

    Operation(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {return this.identifier;}
}
