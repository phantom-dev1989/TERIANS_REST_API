package com.terians.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

/**
 * Created by stromero on 3/1/2015.
 */

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
