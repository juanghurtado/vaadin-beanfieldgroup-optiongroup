package com.viavansi.vaadinsample.models;

import java.io.Serializable;

public class CityDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 9108472755053042201L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}