package com.saq.taxipark.server.listener;

import com.saq.taxipark.common.model.mq.MQGeoLocation;
import com.saq.taxipark.server.config.ServerProperties;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class GeoLocationListener {
    @KafkaListener(id = "adminclient-15", topics = "#{'${taxipark.server.kafka.topics.geo-topic}'}")
    public void listen(@Payload MQGeoLocation geoLocation) {
        log.info(geoLocation);
    }
}
