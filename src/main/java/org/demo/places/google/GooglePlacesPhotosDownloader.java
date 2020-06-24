package org.demo.places.google;

import java.util.concurrent.Future;

public interface GooglePlacesPhotosDownloader {

    Future<String> downloadImage(String reference, Integer maxWidth);

}
