package org.demo.places.service;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.demo.places.exception.UnreachableDestinationException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Type;

import static java.nio.charset.StandardCharsets.UTF_8;

@Slf4j
@Component
public class HttpInvoker {

    public <T> T get(String uri, Class<T> clasz) {
        try {
            HttpGet get = new HttpGet(uri);
            CloseableHttpClient client = HttpClientBuilder.create().build();

            log.info(String.format("Invoking GET on %s", uri));
            HttpResponse response = client.execute(get);
            String json = IOUtils.toString(response.getEntity().getContent(), UTF_8);
            log.info(uri + " responded " + response.getStatusLine().getStatusCode() + ":\n" + json);
            return new Gson().fromJson(json, (Type) clasz);
        } catch (IOException e) {
            throw new UnreachableDestinationException("Could not invoke specified uri due to: " + e.getMessage(), e);
        }
    }

    public byte[] get(String uri) {
        try {
            HttpGet get = new HttpGet(uri);
            CloseableHttpClient client = HttpClientBuilder.create().build();

            log.info(String.format("Invoking GET on %s", uri));
            HttpResponse response = client.execute(get);
            return IOUtils.toByteArray(response.getEntity().getContent());

        } catch (IOException e) {
            throw new UnreachableDestinationException("Could not invoke specified uri due to: " + e.getMessage(), e);
        }
    }

}
