package com.oliveirasantos.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDateTime;

@Controller
public class WeatherController {
    @Autowired
    private ApiServiceWeather apiServiceWeather;
    @Autowired
    private FileService fileService;

    @GetMapping("/")
    public String showWeatherForm() {
        return "weatherPage";
    }

    @GetMapping("/weather")
public String getWeather(@RequestParam("latitude") double latitude, 
                         @RequestParam("longitude") double longitude, 
                         Model model) {
    try {
        String weatherData = apiServiceWeather.getWeather(latitude, longitude);
        if (weatherData == null || weatherData.trim().isEmpty()) {
            model.addAttribute("error", "No weather data available");
            return "weatherPage";
        }
        
        Consulta consulta = new Consulta(LocalDateTime.now(), latitude, longitude, weatherData);
        Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
            .setPrettyPrinting()
            .create();
        gson.toJson(consulta);
        fileService.saveHistory(consulta);
        
        model.addAttribute("weatherData", weatherData);
    } catch (Exception e) {
        model.addAttribute("error", "Error fetching weather data: " + e.getMessage());
    }
    return "weatherPage";
    }
}
