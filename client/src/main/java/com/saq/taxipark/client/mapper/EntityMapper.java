package com.saq.taxipark.client.mapper;

import com.saq.taxipark.common.model.GeoLocation;
import com.saq.taxipark.common.model.mq.MQGeoLocation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EntityMapper {
    MQGeoLocation toMQEntity(GeoLocation geoLocation);
}
