package com.regex.kafkaProducer.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.regex.kafkaProducer.dto.AlarmDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@RequiredArgsConstructor
@Slf4j
public class AlarmService {
    private static final String TOPIC_NAME = "topic-example1";
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public void sendToKafka(AlarmDto alarmDto) {
        try{
            String jsonInString = objectMapper.writeValueAsString(alarmDto);
            kafkaTemplate.send(TOPIC_NAME, jsonInString);
        } catch (Exception e) {
            log.error("error occured while send to kafka", e);
        }
    }

//    public void sendWithCallback(AlarmDto alarmDto) {
//        try {
//            String jsonInString = objectMapper.writeValueAsString(alarmDto);
//            ListenableFuture<SendResult<String, String>> future = (ListenableFuture<SendResult<String, String>>) this.kafkaTemplate.send(TOPIC_NAME, jsonInString);
//            future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
//                @Override
//                public void onFailure(Throwable ex) {
//                    log.error("failed");
//                }
//
//                @Override
//                public void onSuccess(SendResult<String, String> result) {
//                    log.info("success");
//                }
//            });
//        } catch (Exception e) {
//            log.error("error occured while sendWithCallback", e);
//        }
//    }

}
