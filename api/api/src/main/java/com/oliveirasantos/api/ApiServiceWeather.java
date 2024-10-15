package com.oliveirasantos.api;

import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.net.ConnectException;

@Service
public class ApiServiceWeather {
    private static final int MAX_RETRIES = 3;
    private static final long RETRY_DELAY = 1000; // 1 second

    public String getWeather(double latitude, double longitude) {
        String url = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude=" + longitude + "&hourly=temperature";

        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.br.bosch.com", 8080));
        factory.setProxy(proxy);

        RestTemplate restTemplate = new RestTemplate(factory);

        int retries = 0;
        while (retries < MAX_RETRIES) {
            try {
                ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
                String responseBody = response.getBody();
                
                if (responseBody == null || responseBody.trim().isEmpty()) {
                    System.out.println("Received empty response from API");
                    return null;
                }
                
                System.out.println("API Response (first 1000 chars): " + responseBody.substring(0, Math.min(responseBody.length(), 1000)));
                
                return responseBody;
            } catch (RestClientException e) {
                if (e.getCause() instanceof SocketTimeoutException || e.getCause() instanceof ConnectException) {
                    retries++;
                    System.out.println("Attempt " + retries + " failed. Retrying in " + RETRY_DELAY + "ms...");
                    try {
                        Thread.sleep(RETRY_DELAY);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                } else {
                    System.out.println("Error while trying to consume API: " + e.getMessage());
                    e.printStackTrace();
                    return null;
                }
            }
        }
        System.out.println("Max retries exceeded. Unable to fetch weather data.");
        return null;
    }
}