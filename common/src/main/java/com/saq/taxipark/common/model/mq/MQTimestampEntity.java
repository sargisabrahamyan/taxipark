package com.saq.taxipark.common.model.mq;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
public class MQTimestampEntity extends MQEntity {
    private LocalDateTime timestamp = LocalDateTime.now();
}
