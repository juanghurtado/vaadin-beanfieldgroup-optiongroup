package com.viavansi.vaadinsample.models;

import java.io.Serializable;
import java.util.List;

public class CountryDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 9108474755053042201L;

    private String name;
    private List<CityDTO> cities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CityDTO> getCities() {
        return cities;
    }

    public void setCities(List<CityDTO> cities) {
        this.cities = cities;
    }

}