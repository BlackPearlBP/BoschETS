package com.oliveirasantos.api;

import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ApiServiceMovie {
    @SuppressWarnings("resource")
    public static void main(String[] args) throws UnsupportedEncodingException{
        System.out.println("Hello World!");
        Scanner input = new Scanner(System.in).useDelimiter(" ");
        System.out.println("Enter the movie name: ");
        String movie = URLEncoder.encode(input.nextLine(), "UTF-8");
        String address = "https://www.omdbapi.com/?t="+movie+"&apikey=239920d1";

        try{
            HttpClient client = HttpClient.newBuilder()
            .proxy(ProxySelector.of(new InetSocketAddress("proxy.br.bosch.com", 8080)))
            .build();

            HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(address))
            .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("APIs response: "+response.body());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
