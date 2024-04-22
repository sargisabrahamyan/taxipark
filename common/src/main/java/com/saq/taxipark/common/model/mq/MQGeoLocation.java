package com.saq.taxipark.common.model.mq;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class MQGeoLocation extends MQTimestampEntity {
    private String ipAddress;
    private String city;
    private String country;
    private double latitude;
    private double longitude;
}