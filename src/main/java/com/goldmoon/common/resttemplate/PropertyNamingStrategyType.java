package com.goldmoon.common.resttemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Getter
@AllArgsConstructor
public enum PropertyNamingStrategyType {
    SNAKE_CASE(mappingJackson2HttpMessageConverter(PropertyNamingStrategy.SNAKE_CASE)),
    LOWER_CAMEL_CASE(mappingJackson2HttpMessageConverter(PropertyNamingStrategy.LOWER_CAMEL_CASE)),
    UPPER_CASE(mappingJackson2HttpMessageConverter(new PropertyNamingStrategyUpperCase())),
    BYPASS_CASE(mappingJackson2HttpMessageConverter(new PropertyNamingStrategyBypassCase()))
    ;

    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;

    private static MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(PropertyNamingStrategy propertyNamingStrategy) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(propertyNamingStrategy);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return new MappingJackson2HttpMessageConverter(objectMapper);
    }
}