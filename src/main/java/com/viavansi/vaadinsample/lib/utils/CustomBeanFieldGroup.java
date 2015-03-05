package com.viavansi.vaadinsample.lib.utils;

import com.vaadin.data.Container;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.ui.OptionGroup;
import com.viavansi.vaadinsample.models.BaseDTO;

public class CustomBeanFieldGroup<T extends BaseDTO> extends BeanFieldGroup<T> {

    private static final long serialVersionUID = -1779534183038775123L;
    private FieldGroupProxy proxy;

    // Public API
    // ------------------------------------------------------------------------
    public CustomBeanFieldGroup(Class<T> beanType) {
        super(beanType);

        proxy = new FieldGroupProxy(this);
    }

    public OptionGroup buildAndBindOptionGroup(String caption, Object propertyId, Container container, String captionPropertyId) throws BindException {
        OptionGroup field;

        field = proxy.buildMultiselectOptionGroup(propertyId, container, captionPropertyId);
        field.setCaption(caption);

        bind(field, propertyId);

        return field;
    }

}