package com.app.paketo.thirdparty.weather.client;

import com.app.paketo.to.WeatherTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * FeignClient added instead of RestTemplate for consuming  Weather API
 */
@FeignClient(name = "WeatherAPI", url = "${paketo.weather.url}")
public interface WeatherClient {

    /**
     * This method is used to consume the Weather API
     * @param latitude
     * @param longitude
     * @param apiKey
     * @return
     */
    @GetMapping("")
    public WeatherTO getWeatherDetailByLatAndLon(@RequestParam("lat") String latitude,
                                                 @RequestParam("lon") String longitude,
                                                 @RequestParam("appid") String apiKey);
}
