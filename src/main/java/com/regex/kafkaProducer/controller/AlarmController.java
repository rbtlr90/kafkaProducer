package com.regex.kafkaProducer.controller;

import com.regex.kafkaProducer.dto.AlarmDto;
import com.regex.kafkaProducer.service.AlarmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
public class AlarmController {
    private final AlarmService alarmService;
    @PostMapping("/alarm")
    public AlarmDto setAlarm(
            AlarmDto alarmDto
    ) {
        this.alarmService.sendToKafka(alarmDto);
        return alarmDto;
    };
}
