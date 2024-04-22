package com.saq.taxipark.client.config.kafka;

import lombok.Getter;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class TopicConfig {

    @Value(value = "${taxipark.client.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Value(value = "${taxipark.client.kafka.topics.status-topic}")
    private String statusTopic;

    @Getter
    @Value(value = "${taxipark.client.kafka.topics.geo-topic}")
    private String geoTopic;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic statusTopic() {
        return new NewTopic(statusTopic, 1, (short) 1);
    }

    @Bean
    public NewTopic geoTopic() {
        return new NewTopic(geoTopic, 1, (short) 1);
    }
}