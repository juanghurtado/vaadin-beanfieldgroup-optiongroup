package com.viavansi.vaadinsample.app;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.Widgetset;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.viavansi.vaadinsample.lib.utils.CustomBeanFieldGroup;
import com.viavansi.vaadinsample.models.CityDTO;
import com.viavansi.vaadinsample.models.CountryDTO;

@Theme("vaadinsample")
@Widgetset("com.viavansi.vaadinsample.AppWidgetSet")
@Title("Vaadin BeanFieldGroup OptionGroup")
public final class AppUI extends UI {

    private static final long serialVersionUID = -8429498837198506010L;

    private CustomBeanFieldGroup<CountryDTO> formGroup;
    private BeanContainer<String, CityDTO> citiesContainer;
    private CountryDTO spain;
    private CityDTO seville;
    private CityDTO madrid;
    private CityDTO barcelona;

    @Override
    protected void init(final VaadinRequest request) {
        setupSampleData();
        setupCitiesContainer();
        setupFieldGroup();

        this.setContent(formGroup.buildAndBindOptionGroup("Cities", "cities", citiesContainer, "name"));
    }

    private void setupSampleData() {
        seville = new CityDTO();
        seville.setName("Seville");

        madrid = new CityDTO();
        madrid.setName("Madrid");

        barcelona = new CityDTO();
        barcelona.setName("Barcelona");

        spain = new CountryDTO();
        spain.setName("Spain");
        spain.setCities(getSelectedCities());
    }

    private void setupCitiesContainer() {
        citiesContainer = new BeanContainer<String, CityDTO>(CityDTO.class);

        citiesContainer.setBeanIdProperty("name");
        citiesContainer.addBean(seville);
        citiesContainer.addBean(madrid);
        citiesContainer.addBean(barcelona);
    }

    private void setupFieldGroup() {
        formGroup = new CustomBeanFieldGroup<CountryDTO>(CountryDTO.class);
        formGroup.setItemDataSource(spain);
    }

    private List<CityDTO> getSelectedCities() {
        List<CityDTO> selectedCities = new ArrayList<CityDTO>();

        selectedCities.add(madrid);
        selectedCities.add(barcelona);

        return selectedCities;
    }

}
