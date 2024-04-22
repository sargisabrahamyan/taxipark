package com.saq.taxipark.common.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper=true)
public class Driver extends Entity<UUID> {
    private DriverInfo driverInfo;
    private GeoLocation geoLocation;
    private DriverStatus status;
}
