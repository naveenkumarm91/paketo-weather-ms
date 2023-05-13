package com.app.paketo.to;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Map;

@Data
@Builder
@ToString
public class GeoLocationDetailTO {
    /**
     *
     */
    @JsonProperty("name")
    private String cityName;
    /**
     *
     */
    @JsonProperty("local_names")
    private Map<String, String> localName;
    /**
     *
     */
    @JsonProperty("lat")
    private String latitude;
    /**
     *
     */
    @JsonProperty("lon")
    private String longitude;
    /**
     *
     */
    @JsonProperty("country")
    private String country;
    /**
     *
     */
    @JsonProperty("state")
    private String state;


}
