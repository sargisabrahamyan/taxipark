package com.saq.taxipark.client.mapper;

import com.saq.taxipark.common.model.GeoLocation;
import com.saq.taxipark.common.model.mq.MQGeoLocation;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-21T16:55:04+0400",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
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
