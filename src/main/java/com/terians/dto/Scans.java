package com.terians.dto;

import java.util.Set;

/**
 * Created by stromero on 3/1/2015.
 */
public class Scans {

    private Set<Scan> scans;

    public Scans() {
    }

    public Scans(Set<Scan> scans) {
        this.scans = scans;
    }

    public Set<Scan> getScans() {
        return scans;
    }

    public void setScans(Set<Scan> scans) {
        this.scans = scans;
    }

}
