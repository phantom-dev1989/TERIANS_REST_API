package com.terians.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wordnik.swagger.annotations.ApiModel;

import java.util.List;

/**
 * Created by stromero on 3/1/2015.
 */
@ApiModel("Vulnerabilities")
public class VulnerabilitiesDTO {

    private int totalVulnerabilities;
    @JsonProperty("vulnerabilityList")
    private List<VulnerabilityDTO> vulnerabilityDTOList;

    public VulnerabilitiesDTO() {

    }

    public List<VulnerabilityDTO> getVulnerabilityDTOList() {
        return vulnerabilityDTOList;
    }

    public void setVulnerabilityDTOList(List<VulnerabilityDTO> vulnerabilityDTOList) {
        this.vulnerabilityDTOList = vulnerabilityDTOList;
    }

    public int getTotalVulnerabilities() {
        return totalVulnerabilities;
    }

    public void setTotalVulnerabilities(int totalVulnerabilities) {
        this.totalVulnerabilities = totalVulnerabilities;
    }
}
