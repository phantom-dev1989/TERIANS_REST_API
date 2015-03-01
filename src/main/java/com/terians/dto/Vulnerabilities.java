package com.terians.dto;

import java.util.Set;

/**
 * Created by stromero on 3/1/2015.
 */
public class Vulnerabilities {

    private Set<Vulnerability> vulnerabilities;

    public Vulnerabilities() {

    }

    public Vulnerabilities(Set<Vulnerability> vulnerabilities) {
        this.vulnerabilities = vulnerabilities;
    }

    public Set<Vulnerability> getVulnerabilities() {
        return vulnerabilities;
    }

    public void setVulnerabilities(Set<Vulnerability> vulnerabilities) {
        this.vulnerabilities = vulnerabilities;
    }
}
