package com.terians.neo4j.service;

import com.terians.dto.ProjectDTO;
import com.terians.dto.ProjectsDTO;
import com.terians.dto.ScanDTO;
import com.terians.dto.ScansDTO;

/**
 * Created by stromero on 1/4/2015.
 */
public interface ProjectService {

    public ProjectsDTO findAllProjects();

    public ProjectDTO findProjectById(String teriansId);

    public ScansDTO findAllScansByProject(String teriansId);
}
