package com.app.paketo.to;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Data
@Builder
@ToString
public class WeatherTO {

    @JsonProperty("coord")
    private Cordinates cordinates;
    @JsonProperty("weather")
    private List<Weather> weather;
    @JsonProperty("base")
    private String base;
    @JsonProperty("main")
    private Main main;
    @JsonProperty("visibility")
    private String visibility;
    @JsonProperty("wind")
    private Wind wind;
    @JsonProperty("rain")
    private Map<String, String> rain;
    @JsonProperty("clouds")
    private Map<String, String> clouds;
    @JsonProperty("dt")
    private long date;
    @JsonProperty("sys")
    private System system;
    @JsonProperty("timezone")
    private String timeZone;
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("cod")
    private String cod;

    private static class Cordinates {
        @JsonProperty("lat")
        private String latitude;
        @JsonProperty("lon")
        private String longitude;
    }

    private static class Weather {
        @JsonProperty("id")
        private long id;
        @JsonProperty("main")
        private String main;
        @JsonProperty("description")
        private String description;
        @JsonProperty("icon")
        private String icon;
    }

    private static class Main {
        @JsonProperty("temp")
        private String temp;
        @JsonProperty("feels_like")
        private String feelsLike;
        @JsonProperty("temp_min")
        private String minTemp;
        @JsonProperty("temp_max")
        private String maxTemp;
        @JsonProperty("pressure")
        private String pressure;
        @JsonProperty("humidity")
        private String humidity;
        @JsonProperty("sea_level")
        private String seaLevel;
        @JsonProperty("grnd_level")
        private String groundLevel;
    }

    private static class Wind {
        @JsonProperty("speed")
        private String speed;
        @JsonProperty("deg")
        private String degree;
        @JsonProperty("gust")
        private String gusture;
    }

    private static class System {
        @JsonProperty("type")
        private String type;
        @JsonProperty("id")
        private String id;
        @JsonProperty("country")
        private String country;
        @JsonProperty("sunrise")
        private String sunrise;
        @JsonProperty("sunset")
        private String sunset;
    }
}
