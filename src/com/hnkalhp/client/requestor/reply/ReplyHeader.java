package com.hnkalhp.client.requestor.reply;

import java.io.Serializable;

/**
 * Created by ceciliahunka on 24/09/17.
 */
public class ReplyHeader implements Serializable {
    private String serviceContext;
    private int requestId;
    private int replyStatus;
}
