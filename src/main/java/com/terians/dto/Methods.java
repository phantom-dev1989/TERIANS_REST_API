package com.terians.dto;

import java.util.Set;

/**
 * Created by stromero on 3/1/2015.
 */
public class Methods {

    private Set<Method> method;

    public Methods() {
    }

    public Methods(Set<Method> method) {
        this.method = method;
    }

    public Set<Method> getMethod() {
        return method;
    }

    public void setMethod(Set<Method> method) {
        this.method = method;
    }
}
