package org.demo.places.google;


import static com.google.common.base.Preconditions.checkNotNull;
import static org.demo.places.google.Operation.*;

public class GooglePlacesUri {
    static final String GOOGLE_PLACES_ENDPOINT = "https://maps.googleapis.com/maps/api/place";
    static final String GOOGLE_API_KEY = "#####GOOGLE_API_KEY#####";

    static GoogleNearbySearchUriBuilder nearbySearchUriBuilder() {
        return new GoogleNearbySearchUriBuilder();
    }

    static GooglePlaceDetailsUriBuilder placeDetailsUriBuilder() {
        return new GooglePlaceDetailsUriBuilder();
    }

    static GooglePlacePhotosUriBuilder placePhotosUriBuilder() {
        return new GooglePlacePhotosUriBuilder();
    }

    public static class GoogleNearbySearchUriBuilder {
        private Operation operation;
        private String outputType;
        private Double longitude;
        private Double latitude;
        private Integer radius;
        private String apiKey;

        GoogleNearbySearchUriBuilder() {
            this.operation = NEARBY_SEARCH;
        }

        GoogleNearbySearchUriBuilder outputType(String outputType) {
            this.outputType = outputType;
            return this;
        }

        GoogleNearbySearchUriBuilder longitude(Double longitude) {
            this.longitude = longitude;
            return this;
        }

        GoogleNearbySearchUriBuilder latitude(Double latitude) {
            this.latitude = latitude;
            return this;
        }

        GoogleNearbySearchUriBuilder radius(Integer radius) {
            this.radius = radius;
            return this;
        }

        GoogleNearbySearchUriBuilder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        String build() {
            checkNotNull(operation, "The operation must be set.");
            checkNotNull(outputType, "The outputType must be set.");
            checkNotNull(latitude, "The latitude must be set.");
            checkNotNull(longitude, "The longitude must be set.");
            checkNotNull(radius, "The latitude must be set.");

            return GOOGLE_PLACES_ENDPOINT + operation.getIdentifier() + "/" + outputType +
                    "?location=" + latitude + "," + longitude +
                    "&radius=" + radius +
                    "&key=" + (apiKey != null ? apiKey : GOOGLE_API_KEY);
        }

    }

    public static class GooglePlaceDetailsUriBuilder {
        private Operation operation;
        private String outputType;
        private String placeId;
        private String apiKey;

        GooglePlaceDetailsUriBuilder() {
            this.operation = DETAILS;
        }

        GooglePlaceDetailsUriBuilder outputType(String outputType) {
            this.outputType = outputType;
            return this;
        }

        GooglePlaceDetailsUriBuilder placeId(String placeId) {
            this.placeId = placeId;
            return this;
        }

        GooglePlaceDetailsUriBuilder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        String build() {
            checkNotNull(outputType, "The outputType must be set.");
            checkNotNull(placeId, "The placeId must be set.");
            return GOOGLE_PLACES_ENDPOINT + operation.getIdentifier() + "/" + outputType +
                    "?place_id=" + placeId +
//                    "&fields=" + "address_component,adr_address,business_status,formatted_address,geometry,icon,name,photo,place_id,plus_code,type,url,utc_offset,vicinity" +
                    "&key=" + (apiKey != null ? apiKey : GOOGLE_API_KEY);
        }
    }

    protected static class GooglePlacePhotosUriBuilder {
        private Operation operation;
        private String reference;
        private String maxWidth;
        private String apiKey;

        public GooglePlacePhotosUriBuilder() {
            this.operation = PHOTO;
        }

        public GooglePlacePhotosUriBuilder reference(String reference) {
            this.reference = reference;
            return this;
        }

        public GooglePlacePhotosUriBuilder maxWidth(String maxWidth) {
            this.maxWidth = maxWidth;
            return this;
        }

        GooglePlacePhotosUriBuilder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        String build() {
            checkNotNull(reference, "The reference must be set.");
            return GOOGLE_PLACES_ENDPOINT + operation.getIdentifier() +
                    "?maxwidth=" + maxWidth +
                    "?photoreference==" + reference +
                    "&key=" + (apiKey != null ? apiKey : GOOGLE_API_KEY);
        }
    }
}
