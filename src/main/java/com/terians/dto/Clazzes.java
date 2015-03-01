package com.terians.dto;

import java.util.Set;

/**
 * Created by stromero on 3/1/2015.
 */
public class Clazzes {

    private Set<Clazz> clazzs;

    public Clazzes() {
    }

    public Clazzes(Set<Clazz> clazzs) {
        this.clazzs = clazzs;
    }

    public Set<Clazz> getClazzs() {
        return clazzs;
    }

    public void setClazzs(Set<Clazz> clazzs) {
        this.clazzs = clazzs;
    }
}
