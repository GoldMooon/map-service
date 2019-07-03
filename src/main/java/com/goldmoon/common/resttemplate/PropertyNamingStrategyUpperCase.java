package com.goldmoon.common.resttemplate;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;

public class PropertyNamingStrategyUpperCase extends PropertyNamingStrategy.PropertyNamingStrategyBase {
    @Override
    public String translate(String input) {
        return input.toUpperCase();
    }
}