package com.danza.java.features;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientTest {

    @Test
    void get() throws IOException, InterruptedException {

        var httpClient = HttpClient.newHttpClient();

        var httpRequest = HttpRequest.newBuilder().GET().uri(URI.create("https://www.google.com")).build();

        var httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        Assertions.assertEquals(200, httpResponse.statusCode());
        System.out.println(httpResponse.headers());
    }
}
