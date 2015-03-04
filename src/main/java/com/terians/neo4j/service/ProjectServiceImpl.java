package com.terians.neo4j.service;


import com.terians.dto.ProjectDTO;
import com.terians.dto.ProjectsDTO;
import com.terians.dto.transformer.DTOTransformerUtil;
import com.terians.neo4j.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by stromero on 1/4/2015.
 */
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository repository;


    @Override
    public ProjectsDTO findAllProjects() {
        return DTOTransformerUtil.transformProjectSetToProjectsDTO(repository.findAllProjects());
    }

    @Override
    public ProjectDTO findProjectById(String teriansId) {
        return DTOTransformerUtil.transformProjectToProjectDTO(repository.findProjectById(teriansId));
    }

}
