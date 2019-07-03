package com.goldmoon.common.resttemplate;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RestTemplateCondition {
    private Integer connectionTimeout;
    private Integer readTimeout;
    private PropertyNamingStrategyType propertyNamingStrategyType;
    private Boolean useHttps;
    private Boolean useProxy;
    private Integer maxConnPerRoute;
    private Integer maxConnTotal;
    private Boolean notUseDefaultCharsets;

    @Override
    public String toString() {
        if (propertyNamingStrategyType == null) {
            return connectionTimeout + "_" + readTimeout + "_" + useHttps + "_" + useProxy + "_" + maxConnPerRoute + "_" + maxConnTotal + "_" + notUseDefaultCharsets;
        }
        return connectionTimeout + "_" + readTimeout + "_" + propertyNamingStrategyType.name() + "_" + useHttps + "_" + useProxy + "_" + maxConnPerRoute + "_" + maxConnTotal + "_" + notUseDefaultCharsets;
    }

    @Builder
    public RestTemplateCondition(Integer connectionTimeout, Integer readTimeout, PropertyNamingStrategyType propertyNamingStrategyType, Boolean useHttps, Boolean useProxy, Integer maxConnPerRoute, Integer maxConnTotal, Boolean notUseDefaultCharsets) {
        this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.propertyNamingStrategyType = propertyNamingStrategyType;
        this.useHttps = useHttps;
        this.useProxy = useProxy;
        this.maxConnPerRoute = maxConnPerRoute;
        this.maxConnTotal = maxConnTotal;
        this.notUseDefaultCharsets = notUseDefaultCharsets;
    }
}
