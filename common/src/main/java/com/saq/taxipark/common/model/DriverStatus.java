package com.saq.taxipark.common.model;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum DriverStatus {
    FREE("Free"),
    PASSENGER("Passenger"),
    COMMING("Comming"),
    BUSY("Busy"),
    UNKNOWN("Unknown");

    private final String value;

    DriverStatus(String value) {
        this.value = value;
    }

    public static Optional<DriverStatus> fromString(String s) {
        return  Arrays.stream(values()).filter(v -> v.toString().equalsIgnoreCase(s)).findFirst();
    }

    public static String allToString() {
        return Stream.of(DriverStatus.values()).map(DriverStatus::name)
            .collect(Collectors.joining(", ", "[", "]"));
    }
}
