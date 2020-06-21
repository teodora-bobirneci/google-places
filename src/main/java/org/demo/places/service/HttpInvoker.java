package org.demo.places.service;

import com.google.gson.Gson;
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


@Component
public class HttpInvoker {

    public <T> T get(String uri, Class<T> classz) {
        try {
            HttpGet get = new HttpGet(uri);
            CloseableHttpClient client = HttpClientBuilder.create().build();

            HttpResponse response = client.execute(get);
            return new Gson().fromJson(IOUtils.toString(response.getEntity().getContent(), UTF_8), (Type) classz);
        } catch (IOException e) {
            throw new UnreachableDestinationException("Could not invoke specified uri due to: " + e.getMessage(), e);
        }
    }

}
