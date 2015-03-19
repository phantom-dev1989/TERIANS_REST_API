package com.terians.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wordnik.swagger.annotations.ApiModel;

import java.util.List;

/**
 * Created by stromero on 3/1/2015.
 */
@ApiModel("Projects")
public class ProjectsDTO {

	private int totalProjects;
	@JsonProperty("projectList")
	private List<ProjectDTO> projectDTOList;

	public ProjectsDTO() {
	}

	public List<ProjectDTO> getProjectDTOList() {
		return projectDTOList;
	}

	public void setProjectDTOList(List<ProjectDTO> projectDTOList) {
		this.projectDTOList = projectDTOList;
	}

	public int getTotalProjects() {
		return totalProjects;
	}

	public void setTotalProjects(int totalProjects) {
		this.totalProjects = totalProjects;
	}
}
