package com.viavansi.vaadinsample.lib.utils;

import com.vaadin.data.Container;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.ui.OptionGroup;

public class FieldGroupProxy {

    private FieldGroup fieldGroup;

    public FieldGroupProxy(FieldGroup fieldGroup) {
        this.fieldGroup = fieldGroup;
    }

    public OptionGroup buildMultiselectOptionGroup(Object fieldId, Container container, String captionPropertyId) {
        OptionGroup field = new OptionGroup();

        if (container.size() > 0) {
            field.setContainerDataSource(container);
            field.setMultiSelect(true);
            field.setConverter(new AbstractMultiSelectToDTOConverter(field));
            field.setItemCaptionPropertyId(captionPropertyId);
        } else {
            field.setVisible(false);
        }

        return field;
    }

}
