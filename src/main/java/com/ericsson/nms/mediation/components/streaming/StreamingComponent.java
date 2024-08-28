package com.ericsson.nms.mediation.components.streaming;

import java.util.Map;

import org.apache.camel.Endpoint;
import org.apache.camel.impl.DefaultComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents the component that manages {@link StreamingEndpoint}.
 */
public class StreamingComponent extends DefaultComponent {
    private static final Logger LOGGER = LoggerFactory.getLogger(StreamingComponent.class);
    protected String port;

    public String getPort() {
        return this.port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public StreamingComponent() {
        super();
        LOGGER.debug("constructing streaming component;");
    }

    @Override
    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        StreamingEndpoint endpoint = new StreamingEndpoint(uri, this);
        this.setProperties(endpoint, parameters);

        LOGGER.info("streaming terminator is configured to listen on the port: {}", endpoint.getPort());

        return endpoint;
    }
}
