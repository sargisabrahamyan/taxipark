package com.saq.taxipark.server.config;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "taxipark")
@Getter
@Setter
public class ServerProperties {

    private String serverKafkaGeoLocationTopic;

    @Getter
    private static String geoLocationTopic;

    @PostConstruct
    public void init() {
        geoLocationTopic = serverKafkaGeoLocationTopic;
    }


}
