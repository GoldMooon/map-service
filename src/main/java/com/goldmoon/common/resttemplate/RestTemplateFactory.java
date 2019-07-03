package com.goldmoon.common.resttemplate;

import com.goldmoon.common.http.client.SimpleHttpRequestRetryHandler;
import com.google.common.collect.Maps;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.NoHttpResponseException;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.NoConnectionReuseStrategy;
import org.apache.http.impl.client.HttpClients;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.*;

@Slf4j
public class RestTemplateFactory {

    private Map<String, RestTemplate> restTemplateMap = Maps.newConcurrentMap();

    private static final Integer DEFAULT_CONNECTION_TIMEOUT = 2000;
    private static final Integer DEFAULT_READ_TIMEOUT = 5000;
    private static final PropertyNamingStrategyType DEFAULT_PROPERTY_NAMING_STRATEGY_TYPE = PropertyNamingStrategyType.SNAKE_CASE;
    private static final Boolean DEFAULT_USE_HTTPS = false;
    private static final Boolean DEFAULT_USE_PROXY = false;
    private final int DEFAULT_MAX_CONN_PER_ROUTE = 64;
    private final int DEFAULT_MAX_CONN_TOTAL = 512;
    private static Boolean DEFAULT_NOT_USE_DEFAULT_CHARSETS = false;

    public RestTemplateFactory() {
    }

    public RestTemplate get() {
        return get(RestTemplateCondition.builder().build());
    }

    public RestTemplate get(RestTemplateCondition build) {
        build.setConnectionTimeout(Optional.ofNullable(build.getConnectionTimeout()).orElse(DEFAULT_CONNECTION_TIMEOUT));
        build.setReadTimeout(Optional.ofNullable(build.getReadTimeout()).orElse(DEFAULT_READ_TIMEOUT));
        build.setPropertyNamingStrategyType(Optional.ofNullable(build.getPropertyNamingStrategyType()).orElse(DEFAULT_PROPERTY_NAMING_STRATEGY_TYPE));
        build.setUseHttps(Optional.ofNullable(build.getUseHttps()).orElse(DEFAULT_USE_HTTPS));
        build.setUseProxy(Optional.ofNullable(build.getUseProxy()).orElse(DEFAULT_USE_PROXY));
        build.setMaxConnPerRoute(Optional.ofNullable(build.getMaxConnPerRoute()).orElse(DEFAULT_MAX_CONN_PER_ROUTE));
        build.setMaxConnTotal(Optional.ofNullable(build.getMaxConnTotal()).orElse(DEFAULT_MAX_CONN_TOTAL));

        if (restTemplateMap.containsKey(build.toString())) {
            return restTemplateMap.get(build.toString());
        }

        RestTemplate restTemplate = getRestTemplate(build);
        restTemplate.getMessageConverters().removeIf(converter -> converter instanceof MappingJackson2HttpMessageConverter);
        restTemplate.getMessageConverters().add(build.getPropertyNamingStrategyType().getMappingJackson2HttpMessageConverter());

        if (Optional.ofNullable(build.getNotUseDefaultCharsets()).orElse(DEFAULT_NOT_USE_DEFAULT_CHARSETS)) {
            List<HttpMessageConverter<?>> converters = new ArrayList<>();
            StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
            stringHttpMessageConverter.setWriteAcceptCharset(false);
            converters.add(stringHttpMessageConverter);
            restTemplate.setMessageConverters(converters);
        }

        restTemplateMap.put(build.toString(), restTemplate);

        return restTemplate;
    }

    private RestTemplate getRestTemplate(RestTemplateCondition build) {
        return new RestTemplateBuilder()
            .setConnectTimeout(build.getConnectionTimeout())
            .setReadTimeout(build.getReadTimeout())
            .requestFactory(() -> new BufferingClientHttpRequestFactory(
                new HttpComponentsClientHttpRequestFactory(
                    HttpClients.custom()
                        .setSSLHostnameVerifier(new NoopHostnameVerifier())
                        .setConnectionReuseStrategy(NoConnectionReuseStrategy.INSTANCE)
                        .setRetryHandler(this.getHttpRequestRetryHandler())
                        .setMaxConnPerRoute(build.getMaxConnPerRoute())
                        .setMaxConnTotal(build.getMaxConnTotal())
                        .build())))
            .build();
    }

    private SimpleHttpRequestRetryHandler getHttpRequestRetryHandler() {
        return new SimpleHttpRequestRetryHandler(3, false, Arrays.asList(
                NoHttpResponseException.class,
                InterruptedIOException.class,
                UnknownHostException.class,
                ConnectException.class,
                SSLException.class
        ));
    }
}
