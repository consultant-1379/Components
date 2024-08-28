package com.ericsson.nms.mediation.components.streaming;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.apache.camel.*;
import org.apache.camel.impl.DefaultEndpoint;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents a Streaming endpoint.
 */
public class StreamingEndpoint extends DefaultEndpoint {
    private static final Logger LOGGER = LoggerFactory.getLogger(StreamingEndpoint.class);
    private ServerBootstrap bootstrap;

    @Override
    protected void doStart() throws Exception {

        super.doStart();
        LOGGER.debug("starting to listen on the port {}", this.port);

        this.bootstrap = new ServerBootstrap(new NioServerSocketChannelFactory(Executors.newCachedThreadPool(), Executors.newCachedThreadPool()));

        this.bootstrap.setPipelineFactory(new StreamingProtocolFactory());
        this.bootstrap.setOption("child.tcpNoDelay", true);
        this.bootstrap.setOption("child.keepAlive", true);
        this.bootstrap.setOption("child.reuseAddress", true);
        this.bootstrap.setOption("tcpNoDelay", true);
        this.bootstrap.setOption("reuseAddress", true);
        this.bootstrap.bind(new InetSocketAddress(Integer.parseInt(this.port)));

        LOGGER.info("component is LISTENING on the port {}", this.port);

    }

    @Override
    protected void doStop() throws Exception {

        super.doStop();
        LOGGER.info("stopping component ");
        this.bootstrap.releaseExternalResources();
    }


    public String getPort() {
        return this.port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    private String port;

    public StreamingEndpoint() {
    }

    public StreamingEndpoint(String uri, StreamingComponent component) {
        super(uri, component);
    }

    public StreamingEndpoint(String endpointUri) {
        super(endpointUri);
    }

    @Override
    public Producer createProducer() throws Exception {
        return new StreamingProducer(this);
    }

    @Override
    public Consumer createConsumer(Processor processor) throws Exception {
        return new StreamingConsumer(this, processor);
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
