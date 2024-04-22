package com.saq.taxipark.client.producer;

import com.saq.taxipark.client.config.kafka.TopicConfig;
import com.saq.taxipark.client.exception.GeoProducerRuntimeException;
import com.saq.taxipark.common.model.mq.MQGeoLocation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Log4j2
@Component
@RequiredArgsConstructor
public class GeoProducer {
    private final TopicConfig topicConfig;
    private final KafkaTemplate<String, MQGeoLocation> kafkaTemplate;

    public void sendMessage(MQGeoLocation geoLocation) {
        try {
            CompletableFuture<SendResult<String, MQGeoLocation>> future = kafkaTemplate.send(topicConfig.getGeoTopic(), geoLocation);
            future.whenComplete((result, ex) -> {
                if (ex == null) {
                    log.info("Sent message=[" + geoLocation.toString() + "] with offset=[" + result.getRecordMetadata().offset() + "]");
                } else {
                    log.error("Unable to send message=[" + geoLocation.toString() + "] due to : " + ex.getMessage());
                }
            });
        } catch (KafkaException e) {
            String errorMsg = "Unable to send message=[" + geoLocation.toString() + "] due to : " + e.getMessage();
            log.error(errorMsg, e);
            throw new GeoProducerRuntimeException(errorMsg);
        }

    }
}
