package com.ericsson.nms.mediation.components.streaming;

import org.jboss.netty.channel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public final class StreamingProtocolFactory implements ChannelPipelineFactory {
	private static final Logger LOGGER = LoggerFactory.getLogger(StreamingProtocolFactory.class);
	//private static final ChannelUpstreamHandler[] CHANNEL_UPSTREAM_HANDLERS = new ChannelUpstreamHandler[]{new DecoderHandler(),new StreamIndicatorHandler(), new RecordHandler(), new FilterHandler() , new StatisticHandler()};
	// emaomic: pipeline can't be singleton
	// private static final ChannelPipeline USPTREAM_PIPELINE = Channels.pipeline(CHANNEL_UPSTREAM_HANDLERS);
	
	@Override
	public ChannelPipeline getPipeline() throws Exception {
		LOGGER.debug("producing new pipeline!");
		return Channels.pipeline(getChannelUpstreamHandlers());
	}
	
	public static ChannelUpstreamHandler[] getChannelUpstreamHandlers(){
        return new ChannelUpstreamHandler[] { new DecoderHandler() };
	}

}
