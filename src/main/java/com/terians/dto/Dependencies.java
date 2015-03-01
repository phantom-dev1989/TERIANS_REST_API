package com.terians.dto;

import java.util.Set;

/**
 * Created by stromero on 3/1/2015.
 */
public class Dependencies {

    private Set<Dependency> dependencies;

    public Dependencies() {
    }

    public Dependencies(Set<Dependency> dependencies) {
        this.dependencies = dependencies;
    }

    public Set<Dependency> getDependencies() {
        return dependencies;
    }

    public void setDependencies(Set<Dependency> dependencies) {
        this.dependencies = dependencies;
    }
}
