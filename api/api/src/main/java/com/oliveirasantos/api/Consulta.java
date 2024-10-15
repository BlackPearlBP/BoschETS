package com.oliveirasantos.api;

import java.time.LocalDateTime;

public class Consulta {
    private LocalDateTime dataHora;
    private double latitude;
    private double longitude;
    private String weatherData;

    public Consulta(LocalDateTime dataHora, double latitude, double longitude, String weatherData) {
        this.dataHora = dataHora;
        this.latitude = latitude;
        this.longitude = longitude;
        this.weatherData = weatherData;
    }

    // Getters e Setters
    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }
    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }
    public String getWeatherData() { return weatherData; }
    public void setWeatherData(String weatherData) { this.weatherData = weatherData; }
}