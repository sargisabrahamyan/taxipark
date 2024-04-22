package com.saq.taxipark.client.mapper;

import com.saq.taxipark.common.model.GeoLocation;
import com.saq.taxipark.common.model.mq.MQGeoLocation;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-21T16:54:51+0400",
    comments = "version: 1.6.0.Beta1, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 20.0.1 (Amazon.com Inc.)"
)
@Component
public class EntityMapperImpl implements EntityMapper {

    @Override
    public MQGeoLocation toMQEntity(GeoLocation geoLocation) {
        if ( geoLocation == null ) {
            return null;
        }

        MQGeoLocation.MQGeoLocationBuilder mQGeoLocation = MQGeoLocation.builder();

        mQGeoLocation.ipAddress( geoLocation.getIpAddress() );
        mQGeoLocation.city( geoLocation.getCity() );
        mQGeoLocation.country( geoLocation.getCountry() );
        mQGeoLocation.latitude( geoLocation.getLatitude() );
        mQGeoLocation.longitude( geoLocation.getLongitude() );

        return mQGeoLocation.build();
    }
}
