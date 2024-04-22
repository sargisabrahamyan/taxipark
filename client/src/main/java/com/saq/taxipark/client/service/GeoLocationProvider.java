package com.saq.taxipark.client.service;

import com.saq.taxipark.common.model.GeoLocation;

import java.awt.*;
import java.util.concurrent.Callable;

public interface GeoLocationProvider extends Callable<GeoLocation> {
    GeoLocation getLocation();

    @Override
    default GeoLocation call() throws Exception {
        return getLocation();
    }
}
