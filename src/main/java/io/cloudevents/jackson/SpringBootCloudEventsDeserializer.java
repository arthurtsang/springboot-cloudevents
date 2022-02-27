package io.cloudevents.jackson;

import org.springframework.boot.jackson.JsonComponent;

/**
 * adding CloudEvent to Jackson
 */
@JsonComponent
public class SpringBootCloudEventsDeserializer extends CloudEventDeserializer {
}
