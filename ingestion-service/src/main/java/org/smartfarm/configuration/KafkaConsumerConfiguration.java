package org.smartfarm.configuration;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.SeekToCurrentErrorHandler;

import java.util.*;

@Configuration
public class KafkaConsumerConfiguration {

    @Value(value = "${kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Value(value = "${kafka.consumer.group-id}")
    private String configCg;

    @Value(value = "${kafka.consumer.auto-offset-reset}")
    private String configResetOffset;

    @Bean
    public ConsumerFactory<String, String> configEventConsumerFactory(){
        List<String> bootstrapServers = new ArrayList<>(Collections.singletonList(bootstrapAddress));
        Map<String, Object> props = new HashMap<>();

        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, configCg);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, configResetOffset);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(props);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> tsEventListener() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory
                = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(configEventConsumerFactory());
        factory.setAckDiscarded(true);
        factory.setErrorHandler(new SeekToCurrentErrorHandler());
        return factory;
    }


}
