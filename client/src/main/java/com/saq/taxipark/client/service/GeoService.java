package com.saq.taxipark.client.service;

import com.saq.taxipark.common.model.GeoLocation;

public interface GeoService {
    void sendLocation(GeoLocation location);
}
