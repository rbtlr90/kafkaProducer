package com.regex.kafkaProducer.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AlarmDto {
    private Long alarmId;
    private Integer alarmLevel;
    private Integer alarmValue;
}
