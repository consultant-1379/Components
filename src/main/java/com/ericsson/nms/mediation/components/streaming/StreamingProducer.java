package com.ericsson.nms.mediation.components.streaming;

import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Streaming producer.
 */
public class StreamingProducer extends DefaultProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(StreamingProducer.class);
    private final StreamingEndpoint endpoint;

    public StreamingProducer(StreamingEndpoint endpoint) {
        super(endpoint);

        LOGGER.debug("constructiong stream produder");
        this.endpoint = endpoint;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        LOGGER.debug("exchnage: {}", exchange.getIn().getBody());
    }

}
