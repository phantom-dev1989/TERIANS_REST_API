package com.terians.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

/**
 * Created by stromero on 3/1/2015.
 */
@JsonRootName("Projects")
public class ProjectsDTO {

    private int totalProjects;
    @JsonProperty("ProjectList")
    private List<ProjectDTO> projects;

    public ProjectsDTO() {
    }

    public ProjectsDTO(List<ProjectDTO> projects, int totalProjects) {
        this.projects = projects;
        this.totalProjects = totalProjects;
    }

    public List<ProjectDTO> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectDTO> projects) {
        this.projects = projects;
    }

    public int getTotalProjects() {
        return totalProjects;
    }

    public void setTotalProjects(int totalProjects) {
        this.totalProjects = totalProjects;
    }
}
