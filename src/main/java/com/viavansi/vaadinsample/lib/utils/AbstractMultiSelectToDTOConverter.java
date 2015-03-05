package com.viavansi.vaadinsample.lib.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.converter.Converter;
import com.vaadin.ui.AbstractSelect;
import com.viavansi.vaadinsample.models.BaseDTO;

public class AbstractMultiSelectToDTOConverter implements Converter<Object, List<BaseDTO>> {

    private static final long serialVersionUID = -7589634171531062832L;
    private BeanContainer<Long, BaseDTO> container;

    private final static Set<BaseDTO> MODEL_TYPE_INSTANCE = new HashSet<BaseDTO>();

    @SuppressWarnings("unchecked")
    public AbstractMultiSelectToDTOConverter(AbstractSelect field) {
        this.container = (BeanContainer<Long, BaseDTO>) field.getContainerDataSource();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<BaseDTO> convertToModel(Object itemIds, Class<? extends List<BaseDTO>> targetType, Locale locale) throws com.vaadin.data.util.converter.Converter.ConversionException {
        List<BaseDTO> models = new ArrayList<BaseDTO>();

        if (container.size() > 0) {
            for (Object itemId : ((HashSet<Object>) itemIds)) {
                if (container.containsId(itemId)) {
                    models.add(container.getItem(itemId).getBean());
                }
            }
        }

        return models;
    }

    @Override
    public Object convertToPresentation(List<BaseDTO> models, Class<? extends Object> targetType, Locale locale) throws com.vaadin.data.util.converter.Converter.ConversionException {
        List<Object> ids = new ArrayList<Object>();

        for (Object itemId : container.getItemIds()) {
            BaseDTO bean = container.getItem(itemId).getBean();

            for (Object model : models) {
                if (((BaseDTO) model).compareTo(bean)) {
                    ids.add(itemId);
                }
            }
        }

        return ids;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Class<List<BaseDTO>> getModelType() {
        return (Class<List<BaseDTO>>) MODEL_TYPE_INSTANCE.getClass();
    }

    @Override
    public Class<Object> getPresentationType() {
        return Object.class;
    }

}