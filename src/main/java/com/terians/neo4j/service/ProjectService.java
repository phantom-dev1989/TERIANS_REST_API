package com.terians.neo4j.service;

import com.terians.dto.ProjectDTO;
import com.terians.dto.ProjectsDTO;

/**
 * Created by stromero on 1/4/2015.
 */
public interface ProjectService {

    public ProjectsDTO findAllProjects();

    public ProjectDTO findProjectById(String teriansId);
}
