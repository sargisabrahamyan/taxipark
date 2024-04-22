package com.saq.taxipark.common.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GeoLocation {
    private String ipAddress;
    private String city;
    private String country;
    private double latitude;
    private double longitude;
}
