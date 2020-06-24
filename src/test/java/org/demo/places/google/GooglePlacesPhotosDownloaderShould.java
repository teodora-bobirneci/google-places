package org.demo.places.google;

import org.demo.places.Application;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.Future;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = Application.class) class GooglePlacesPhotosDownloaderShould {

    @Autowired private GooglePlacesPhotosDownloader googlePlacesPhotosDownloader;

    @Test void downloadSingleImage() throws Exception {
        Future<String> futureImage = googlePlacesPhotosDownloader.downloadImage("CmRaAAAAKaYfb9i-vUlkQLwasjubZmLfEAgnLwU9uPS5HEOBdDV23HNVqKE_8jIjG3XLvCa_hfy_PQ4AjGUrcUGTVEPXdbQr_op17TmuSyVacEjonp04NFjzoydq5Cp5GPqntgbsEhBtLDBQFwVIOpX_GJS6qkbVGhQHeHVlRg6-4JqKvHM2TuL-gN1nBQ", 400);

        assertThat(futureImage.get()).isNotBlank();
    }

}
