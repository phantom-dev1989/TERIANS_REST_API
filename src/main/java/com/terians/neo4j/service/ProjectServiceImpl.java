package com.terians.neo4j.service;


import com.terians.dto.ProjectDTO;
import com.terians.dto.ProjectsDTO;
import com.terians.dto.ScansDTO;
import com.terians.dto.transformer.DTOTransformerUtil;
import com.terians.neo4j.model.Project;
import com.terians.neo4j.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by stromero on 1/4/2015.
 */
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private Neo4jTemplate template;
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public ProjectsDTO findAllProjects() {
        return DTOTransformerUtil.transformProjectSetToProjectsDTO(projectRepository.findAllProjects());
    }

    @Override
    public ProjectDTO findProjectById(String teriansId) {
        return DTOTransformerUtil.transformProjectToProjectDTO(projectRepository.findProjectById(teriansId));
    }

    @Override
    public ScansDTO findAllScansByProject(String teriansId) {

        Project project = projectRepository.findProjectById(teriansId);
        template.fetch(project.getScans());
        return DTOTransformerUtil.transformScanSetToScansDTO(project.getScans());
    }

}
