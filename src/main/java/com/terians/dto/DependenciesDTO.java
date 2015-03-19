package com.terians.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wordnik.swagger.annotations.ApiModel;

import java.util.List;

/**
 * Created by stromero on 3/1/2015.
 */
@ApiModel("Dependencies")
public class DependenciesDTO {

	private int totalDependencies;
	@JsonProperty("dependencyList")
	private List<DependencyDTO> dependencyDTOList;

	public DependenciesDTO() {
	}

	public List<DependencyDTO> getDependencyDTOList() {
		return dependencyDTOList;
	}

	public void setDependencyDTOList(List<DependencyDTO> dependencyDTOList) {
		this.dependencyDTOList = dependencyDTOList;
	}

	public int getTotalDependencies() {
		return totalDependencies;
	}

	public void setTotalDependencies(int totalDependencies) {
		this.totalDependencies = totalDependencies;
	}
}
