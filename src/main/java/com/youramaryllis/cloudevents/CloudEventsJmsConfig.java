package com.youramaryllis.cloudevents;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cloudevents.CloudEvent;
import io.cloudevents.core.v1.CloudEventV1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Slf4j
public class CloudEventsJmsConfig {

    @Bean
    public MessageConverter jacksonJmsMessageConverter(ObjectMapper objectMapper) {
        log.debug( "loading message converter");
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        // the implementation class is CloudEventV1 but it can't be deserialized
        Map<String, Class<?>> typeIdMapping = new HashMap<>();
        typeIdMapping.put(CloudEventV1.class.getName(), CloudEvent.class);
        converter.setTypeIdMappings(typeIdMapping);
        converter.setObjectMapper(objectMapper);
        return converter;
    }
}
