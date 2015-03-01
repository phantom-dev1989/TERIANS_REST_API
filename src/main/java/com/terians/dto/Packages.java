package com.terians.dto;

import java.util.Set;

/**
 * Created by stromero on 3/1/2015.
 */
public class Packages {

    private Set<Package> packages;

    public Packages() {
    }

    public Packages(Set<Package> packages) {
        this.packages = packages;
    }

    public Set<Package> getPackages() {
        return packages;
    }

    public void setPackages(Set<Package> packages) {
        this.packages = packages;
    }
}
