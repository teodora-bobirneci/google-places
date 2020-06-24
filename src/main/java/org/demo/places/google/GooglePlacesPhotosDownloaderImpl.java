package org.demo.places.google;

import org.demo.places.service.HttpInvoker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import static org.demo.places.google.GooglePlacesUri.placePhotosUriBuilder;

@Service
public class GooglePlacesPhotosDownloaderImpl implements GooglePlacesPhotosDownloader {

    private HttpInvoker httpInvoker;

    @Async @Override public Future<String> downloadImage(String reference, Integer maxWidth) {
        String image = Base64.getEncoder().encodeToString(httpInvoker.get(placePhotosUriBuilder().reference(reference).maxWidth(Integer.toString(maxWidth)).build()));
        return CompletableFuture.completedFuture(image);
    }

    @Autowired public void setHttpInvoker(HttpInvoker httpInvoker) {
        this.httpInvoker = httpInvoker;
    }
}
