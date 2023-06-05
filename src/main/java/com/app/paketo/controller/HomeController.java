package com.app.paketo.controller;

import com.app.paketo.thirdparty.weather.client.LocationClient;
import com.app.paketo.thirdparty.weather.client.WeatherClient;
import com.app.paketo.to.GeoLocationDetailTO;
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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

@Slf4j
@RestController
@RequestMapping("v1/app/")
public class HomeController {

    @Value("${paketo.weather.api-key}")
    private String apiKey;

    @Value("${paketo.icon.url}")
    private String icon;

    @Value("${paketo.icon.url-suffix}")
    private String iconSuffix;

    @Autowired
    private WeatherClient weatherClient;

    @Autowired
    private LocationClient locationClient;

    @GetMapping("home")
    public ResponseEntity<?> getGreeting() {
        Date date = new Date();
        log.info("Hello welcome... @" + date);
        return new ResponseEntity<>("Hello welcome... @" + date, HttpStatus.OK);
    }

    @GetMapping("weather")
    public ResponseEntity<?> getWeatherDetails(@RequestParam("latitude") String latitude,
                                               @RequestParam("longitude") String longitude) {
        log.info("latitude: " + latitude);
        log.info("longitude: " + longitude);

        WeatherTO weatherTO = weatherClient.getWeatherDetailByLatAndLon(latitude, longitude, apiKey);
        return new ResponseEntity<>(weatherTO, org.springframework.http.HttpStatus.OK);
    }

    @GetMapping("location")
    public ResponseEntity<?> getLocationDetails(@RequestParam("search") String searchByName) {
        log.info("Search by: '" + searchByName + "'....");

        List<GeoLocationDetailTO> locationDetailTOList = locationClient
                .getlocationDetailByCityName(searchByName, "1", apiKey);
        return new ResponseEntity<>(locationDetailTOList, org.springframework.http.HttpStatus.OK);
    }

    @GetMapping("current-weather")
    public ResponseEntity<?> getCurrentWeatherDetails(@RequestParam("search") String searchByName) {
        log.info("Search by: '" + searchByName + "'....");

        List<GeoLocationDetailTO> locationDetailTOList = locationClient
                .getlocationDetailByCityName(searchByName, "1", apiKey);

        WeatherTO weatherTO = new WeatherTO();
        if (locationDetailTOList != null && !locationDetailTOList.isEmpty()) {
            Stream<WeatherTO> weatherTOStream = locationDetailTOList.stream().limit(1)
                    .map(val -> weatherClient.getWeatherDetailByLatAndLon(val.getLatitude(), val.getLongitude(), apiKey));
            weatherTO = weatherTOStream.findAny().get();
            log.info("Current Weather info : " + weatherTO);

            if (Objects.nonNull(weatherTO)) {
                weatherTO.getWeather().stream().forEach(val -> {
                    val.setIconUrl(new StringBuilder(icon).append(val.getIcon()).append(iconSuffix).toString());
                });
            }
        }

        return new ResponseEntity<>(weatherTO, org.springframework.http.HttpStatus.OK);
    }

}
