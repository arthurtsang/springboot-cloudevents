package io.cloudevents.jackson;

import org.springframework.boot.jackson.JsonComponent;

/**
 * CloudEventSerializer is provided by cloudevents' java sdk,
 * To set the serializer to spring boot's jackson,
 * we need to annotate the class with @JsonComponent
 */
@JsonComponent
public class SpringBootCloudEventsSerializer extends CloudEventSerializer {
    protected SpringBootCloudEventsSerializer() {
        super(false, false);
    }
}
