package com.ericsson.nms.mediation.components.streaming;


import org.jboss.netty.handler.codec.frame.LengthFieldBasedFrameDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author emaomic
 * 
 */

public class DecoderHandler extends LengthFieldBasedFrameDecoder {

    private static final Logger LOGGER = LoggerFactory.getLogger(DecoderHandler.class);

    private static final int LENGTH_FIELD_OFFSET = 0;
    private static final int LENGTH_FIELD_LENGTH = 2;
    private static final int LENGTH_ADJUSTMENT = -2;
    private static final int INITIAL_BYTES_TO_STRIP = 0;

    private static final int MAX_FRAME_LENGTH = 65000;

    public DecoderHandler() {

        super(MAX_FRAME_LENGTH, LENGTH_FIELD_OFFSET, LENGTH_FIELD_LENGTH, LENGTH_ADJUSTMENT, INITIAL_BYTES_TO_STRIP);

    }

}
