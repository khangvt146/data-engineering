package org.smartfarm.adapter.out;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.smartfarm.application.domain.TsEvent;
import org.smartfarm.application.mapper.KafkaMessageMapper;
import org.smartfarm.application.port.out.SendAlarmPort;
import org.smartfarm.infrastructure.model.PushKafkaMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

@Slf4j
public class PushAlarmKafka implements SendAlarmPort {
    @Autowired
    private KafkaTemplate<String, byte[]> messageToKafkaProducer;

    @Autowired
    private KafkaMessageMapper mapper;

    private final static ObjectMapper objectMapper = new ObjectMapper();

    @Value(value = "${kafka.topics.alarm-topic}")
    private String topicName;

    @Override
    public void sendAlarm(TsEvent event){
        PushKafkaMessage pushKafkaMessage = mapper.toEntityMessage(event);
        String key = null;
        pushKafkaMessage.setMsg("Value exceeds limit");
        ProducerRecord<String, byte[]> msg = null;
        try {
            msg = new ProducerRecord<>(topicName, key, objectMapper.writeValueAsString(pushKafkaMessage).getBytes());
            msg.headers();
            messageToKafkaProducer.send(msg);
            log.info("Send message to kafka: {}", pushKafkaMessage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
