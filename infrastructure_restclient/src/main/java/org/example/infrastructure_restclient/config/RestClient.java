package org.example.infrastructure_restclient.config;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class RestClient<T, V> {
    private final String apiURL = "http://localhost:3000/";
    private final RestTemplate restTemplate;
    private final HttpHeaders httpHeaders;

    public RestClient() {
        restTemplate = new RestTemplate();
        httpHeaders = new HttpHeaders();
        httpHeaders.add("Accept", "*/*");
        httpHeaders.add("content-type", "application/json");
    }

    public T get(String uri, Class<T> type) {
        HttpEntity<String> requestEntity = new HttpEntity<>("", httpHeaders);
        ResponseEntity<T> responseEntity = restTemplate.exchange(apiURL+uri, HttpMethod.GET, requestEntity, type);
        return responseEntity.getBody();
    }

    public T post(String uri, Class<T> type, V data) {
        HttpEntity<V> requestEntity = new HttpEntity<>(data, httpHeaders);
        ResponseEntity<T> responseEntity = restTemplate.exchange(apiURL+uri, HttpMethod.POST, requestEntity, type);
        return responseEntity.getBody();
    }
}
