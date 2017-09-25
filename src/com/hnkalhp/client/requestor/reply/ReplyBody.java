package com.hnkalhp.client.requestor.reply;

import java.io.Serializable;

/**
 * Created by ceciliahunka on 24/09/17.
 */
public class ReplyBody implements Serializable {
    private Object operationResult;

    public ReplyBody() {}

    public Object getOperationResult() {
        return operationResult;
    }

    public void setOperationResult(Object operationResult) {
        this.operationResult = operationResult;
    }
}
