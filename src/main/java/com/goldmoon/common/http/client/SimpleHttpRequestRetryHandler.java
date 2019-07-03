package com.goldmoon.common.http.client;

import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;

import java.io.IOException;
import java.util.Collection;

public class SimpleHttpRequestRetryHandler extends DefaultHttpRequestRetryHandler {

    public SimpleHttpRequestRetryHandler(int retryCount, boolean requestSentRetryEnabled, Collection<Class<? extends IOException>> clazzes) {
        super(retryCount, requestSentRetryEnabled, clazzes);
    }
}
