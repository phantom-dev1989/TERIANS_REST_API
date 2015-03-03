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
    private List<DependencyDTO> dependencies;

    public DependenciesDTO() {
    }

    public DependenciesDTO(List<DependencyDTO> dependencies, int totalDependencies) {
        this.dependencies = dependencies;
        this.totalDependencies = totalDependencies;
    }

    public List<DependencyDTO> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<DependencyDTO> dependencies) {
        this.dependencies = dependencies;
    }

    public int getTotalDependencies() {
        return totalDependencies;
    }

    public void setTotalDependencies(int totalDependencies) {
        this.totalDependencies = totalDependencies;
    }
}
