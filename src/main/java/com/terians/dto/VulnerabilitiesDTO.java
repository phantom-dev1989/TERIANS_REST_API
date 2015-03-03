package com.terians.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

/**
 * Created by stromero on 3/1/2015.
 */
@JsonRootName("Vulnerabilities")
public class VulnerabilitiesDTO {

    private int totalVulnerabilities;
    @JsonProperty("VulnerabilityList")
    private List<VulnerabilityDTO> vulnerabilities;

    public VulnerabilitiesDTO() {

    }

    public VulnerabilitiesDTO(int totalVulnerabilities, List<VulnerabilityDTO> vulnerabilities) {
        this.totalVulnerabilities = totalVulnerabilities;
        this.vulnerabilities = vulnerabilities;
    }

    public List<VulnerabilityDTO> getVulnerabilities() {
        return vulnerabilities;
    }

    public void setVulnerabilities(List<VulnerabilityDTO> vulnerabilities) {
        this.vulnerabilities = vulnerabilities;
    }

    public int getTotalVulnerabilities() {
        return totalVulnerabilities;
    }

    public void setTotalVulnerabilities(int totalVulnerabilities) {
        this.totalVulnerabilities = totalVulnerabilities;
    }
}
