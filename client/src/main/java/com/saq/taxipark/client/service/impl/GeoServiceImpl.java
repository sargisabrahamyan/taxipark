package com.saq.taxipark.client.service.impl;

import com.saq.taxipark.client.executer.ExecutorFactory;
import com.saq.taxipark.client.mapper.EntityMapper;
import com.saq.taxipark.client.producer.GeoProducer;
import com.saq.taxipark.client.service.GeoLocationProvider;
import com.saq.taxipark.client.service.GeoService;
import com.saq.taxipark.common.model.GeoLocation;
import com.saq.taxipark.common.model.mq.MQGeoLocation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.lang.Thread.sleep;
import static java.util.concurrent.TimeUnit.SECONDS;

@Service
@Log4j2
public class GeoServiceImpl implements GeoService {

    private final GeoLocationProvider locationProvider;
    private final int GEO_LOCATION_READ_INTERVAL = 1000;
    private final GeoProducer locationProducer;
    private final EntityMapper mapper;

    public GeoServiceImpl(EntityMapper mapper, GeoLocationProvider locationProvider, GeoProducer locationProducer) {
        this.mapper = mapper;
        this.locationProvider = locationProvider;
        this.locationProducer = locationProducer;
        executeGeoProvider();
    }

    private void executeGeoProvider() {
        ExecutorFactory.provideLocation(this::sendLocation, GEO_LOCATION_READ_INTERVAL);
    }
    public void sendLocation(GeoLocation location) {
        Objects.requireNonNull(location);
        MQGeoLocation mqGeoLocation = mapper.toMQEntity(location);
        locationProducer.sendMessage(mqGeoLocation);
    }

    private void sendLocation() {
        GeoLocation location = locationProvider.getLocation();
        sendLocation(location);
    }
}
