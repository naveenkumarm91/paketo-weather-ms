package com.app.paketo.thirdparty.weather.client;

import com.app.paketo.to.GeoLocationDetailTO;
import com.app.paketo.to.WeatherTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "LocationAPI", url = "${paketo.geo.url}")
public interface LocationClient {

    /**
     * This method is used to consume the location API
     *
     * @param apiKey
     * @return
     */
    @GetMapping("")
    public List<GeoLocationDetailTO> getlocationDetailByCityName(@RequestParam("q") String searchByName,
                                                                 @RequestParam("limit") String limit,
                                                                 @RequestParam("appid") String apiKey);
}
