package com.saq.taxipark.client.service.impl;

import com.saq.taxipark.common.model.GeoLocation;
import com.saq.taxipark.client.service.GeoLocationProvider;
import org.springframework.stereotype.Service;

@Service
public class DummtGeoLocationProvider implements GeoLocationProvider {
    public GeoLocation getLocation() {
        // This should read current location from device
        return GeoLocation.builder()
            .country("DummyCountry")
            .city("DummyCity")
            .latitude(Math.acos(Math.random() * 2 - 1))
            .longitude(Math.random() * Math.PI * 2)
            .build();
    }
}
