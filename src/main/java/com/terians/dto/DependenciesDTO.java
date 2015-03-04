package com.terians.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

/**
 * Created by stromero on 3/1/2015.
 */
@JsonRootName("Dependencies")
public class DependenciesDTO {

    private int totalDependencies;
    @JsonProperty("DependencyList")
    private List<DependencyDTO> dependenciesDTO;

    public DependenciesDTO() {
    }

    public DependenciesDTO(List<DependencyDTO> dependenciesDTO, int totalDependencies) {
        this.dependenciesDTO = dependenciesDTO;
        this.totalDependencies = totalDependencies;
    }

    public List<DependencyDTO> getDependenciesDTO() {
        return dependenciesDTO;
    }

    public void setDependenciesDTO(List<DependencyDTO> dependenciesDTO) {
        this.dependenciesDTO = dependenciesDTO;
    }

    public int getTotalDependencies() {
        return totalDependencies;
    }

    public void setTotalDependencies(int totalDependencies) {
        this.totalDependencies = totalDependencies;
    }
}
