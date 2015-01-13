package com.terians.neo4j.service;

import com.terians.neo4j.model.Project;

/**
 * Created by stromero on 1/4/2015.
 */
public interface ProjectService {
    Project findByName(String projectName);
    Project save(Project project);
}
