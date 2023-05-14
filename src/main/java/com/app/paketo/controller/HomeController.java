package com.app.paketo.controller;

import com.app.paketo.thirdparty.weather.client.WeatherClient;
import com.app.paketo.to.WeatherTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("v1/app/")
public class HomeController {

    @Value("${paketo.weather.api-key}")
    private String apiKey;

    @Value("${paketo.weather.url}")
    private String weatherURL;

    @Autowired
    private WeatherClient weatherClient;

    @GetMapping("home")
    public ResponseEntity<?> getGreeting() {
        Date date = new Date();
        log.info("Hello welcome... @" + date);
        return new ResponseEntity<>("Hello welcome... @" + date, HttpStatus.OK);
    }

    @GetMapping("weather")
    public ResponseEntity<?> getWeatherDetails(@RequestParam("latitude") String latitude,
                                               @RequestParam("longitude") String longitude)
    {
        log.info("latitude: " + latitude);
        log.info("longitude: " + longitude);

        WeatherTO weatherTO = weatherClient.getWeatherDetailByLatAndLon(latitude, longitude, apiKey);
        return new ResponseEntity<>(weatherTO, org.springframework.http.HttpStatus.OK);
    }
}
