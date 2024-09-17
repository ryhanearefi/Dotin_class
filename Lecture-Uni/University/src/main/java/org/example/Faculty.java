package org.example;

import java.lang.reflect.Field;
import java.util.List;

public class Faculty {
    private String name;
    private List<Field> fieldList;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Field> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<Field> fieldList) {
        this.fieldList = fieldList;
    }

    public Faculty(String name, List<Field> fieldList) {
        this.name = name;
        this.fieldList = fieldList;
    }
}
