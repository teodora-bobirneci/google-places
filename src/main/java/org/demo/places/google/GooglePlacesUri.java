package org.demo.places.google;


import static com.google.common.base.Preconditions.checkNotNull;

public class GooglePlacesUri {
    static final String GOOGLE_PLACES_ENDPOINT = "https://maps.googleapis.com/maps/api/place";
    static final String GOOGLE_API_KEY = "#####GOOGLE_API_KEY#####";

    public static GoogleNearbySearchUriBuilder nearbySearchUriBuilder() {
        return new GoogleNearbySearchUriBuilder();
    }

    public static GooglePlaceDetailsUriBuilder placeDetailsUriBuilder() {
        return new GooglePlaceDetailsUriBuilder();
    }

    public static class GoogleNearbySearchUriBuilder {
        private Operation operation;
        private String outputType;
        private Double longitude;
        private Double latitude;
        private Integer radius;

        public GoogleNearbySearchUriBuilder() {
            this.operation = Operation.NEARBY_SEARCH;
        }

        public GoogleNearbySearchUriBuilder outputType(String outputType) {
            this.outputType = outputType;
            return this;
        }

        public GoogleNearbySearchUriBuilder longitude(Double longitude) {
            this.longitude = longitude;
            return this;
        }

        public GoogleNearbySearchUriBuilder latitude(Double latitude) {
            this.latitude = latitude;
            return this;
        }

        public GoogleNearbySearchUriBuilder radius(Integer radius) {
            this.radius = radius;
            return this;
        }

        public String build() {
            checkNotNull(operation, "The operation must be set.");
            checkNotNull(outputType, "The outputType must be set.");
            checkNotNull(latitude, "The latitude must be set.");
            checkNotNull(longitude, "The longitude must be set.");
            checkNotNull(radius, "The latitude must be set.");

            return GOOGLE_PLACES_ENDPOINT + operation.getIdentifier() + "/" + outputType +
                    "?location=" + latitude + "," + longitude +
                    "&radius=" + radius +
                    "&key=" + GOOGLE_API_KEY;
        }

    }

    public static class GooglePlaceDetailsUriBuilder {
        public GooglePlaceDetailsUriBuilder() {
            throw new UnsupportedOperationException("This builder is not yet implemented.");
        }
    }
}
