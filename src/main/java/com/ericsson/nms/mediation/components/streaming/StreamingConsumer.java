package com.ericsson.nms.mediation.components.streaming;

import org.apache.camel.Processor;
import org.apache.camel.impl.DefaultConsumer;

/**
 * The Streaming consumer.
 */
public class StreamingConsumer extends DefaultConsumer {

    private final StreamingEndpoint endpoint;


    public StreamingConsumer(StreamingEndpoint endpoint, Processor processor) {
        super(endpoint, processor);
        this.endpoint = endpoint;
    }
}
