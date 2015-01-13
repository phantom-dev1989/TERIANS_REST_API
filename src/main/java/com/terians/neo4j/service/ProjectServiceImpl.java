package com.terians.neo4j.service;

import com.terians.neo4j.model.Project;
import com.terians.neo4j.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by stromero on 1/4/2015.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository repository;

    @Override
    @Transactional
    public Project findByName(String projectName){

        return repository.findByName(projectName);
    }

    @Override
    @Transactional
    public Project save(Project project){

        return repository.save(project);
    }
}
