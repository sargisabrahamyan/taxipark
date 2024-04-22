package com.saq.taxipark.client.executer;

import lombok.Getter;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class ExecutorFactory {
    private static final int MAX_THREAD_FOR_GEOLOCATION = 3;
    private static final int MAX_THREAD_FOR_GEOLOCATION_SCHEDULER = 3;
    private static final ExecutorFactory factory = new ExecutorFactory();

    @Getter
    private final ScheduledExecutorService geoLocationScheduler;

    @Getter
    private final ExecutorService geoLocationExecutor;

    private ExecutorFactory() {
        geoLocationExecutor = Executors.newFixedThreadPool(MAX_THREAD_FOR_GEOLOCATION);
        geoLocationScheduler = Executors.newScheduledThreadPool(MAX_THREAD_FOR_GEOLOCATION_SCHEDULER);
    }

    private static ExecutorFactory get() {
        return factory;
    }

    public static <T> Future<T> provideLocation(Callable<T> callable) {
        return get().getGeoLocationExecutor().submit(callable);
    }


    public static void provideLocation(Runnable runnable, long delay) {
        get().getGeoLocationScheduler().scheduleWithFixedDelay(runnable, 0, delay, MILLISECONDS);
    }
}
