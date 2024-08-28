package com.ericsson.nms.mediation.components.streaming;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;


public class StreamingComponentTest extends CamelTestSupport {

    @Test
    public void testStreaming() throws Exception {
        MockEndpoint mock = this.getMockEndpoint("mock:result");
        mock.expectedMinimumMessageCount(0);
        
        this.assertMockEndpointsSatisfied();
    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() {
                this.from("Streaming://foo?port=1234").to("log://foo");
                  
            }
        };

    }
}
