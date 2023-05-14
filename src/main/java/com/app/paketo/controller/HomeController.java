package com.app.paketo.controller;

import com.app.paketo.to.WeatherTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

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
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        String uriString =  UriComponentsBuilder.fromHttpUrl(weatherURL)
                .queryParam("lat","{lat}")
                .queryParam("lon","{lon}")
                .queryParam("appid","{appid}")
                .encode().toUriString();

        Map<String,String> paramsMap = new HashMap<>();
        paramsMap.put("lat", latitude);
        paramsMap.put("lon", longitude);
        paramsMap.put("appid", apiKey);

        WeatherTO weatherTO = restTemplate.exchange(uriString, HttpMethod.GET, httpEntity, WeatherTO.class, paramsMap).getBody();
        return new ResponseEntity<>(weatherTO, HttpStatus.OK);
    }
}
