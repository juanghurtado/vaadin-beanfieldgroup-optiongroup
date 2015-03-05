package com.viavansi.vaadinsample.models;

import org.apache.commons.lang3.builder.EqualsBuilder;

public abstract class BaseDTO {

    public boolean compareTo(Object dto) {
        return EqualsBuilder.reflectionEquals(this, dto);
    }

}
