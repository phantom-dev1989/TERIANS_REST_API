package com.terians.neo4j.service;

import com.terians.dto.*;
import com.terians.dto.transformer.DTOTransformerUtil;
import com.terians.neo4j.model.Dependency;
import com.terians.neo4j.model.Issue;
import com.terians.neo4j.model.Method;
import com.terians.neo4j.model.Vulnerability;
import com.terians.neo4j.repository.DependencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by stromero on 1/4/2015.
 */
@Service
@Transactional
public class DependencyServiceImpl implements DependencyService {

    @Autowired
    private Neo4jTemplate template;
    @Autowired
    private DependencyRepository dependencyRepository;

    @Override
    public DependenciesDTO findAllDependencies() {
        return DTOTransformerUtil.transformDependencySetToDependenciesDTO(dependencyRepository.findAllDependencies());
    }

    @Override
    public DependencyDTO findDependency(String dependencyId) {
        return DTOTransformerUtil.transformDependencyToDependencyDTO(dependencyRepository.findDependencyById(dependencyId));
    }

    @Override
    public MethodsDTO findAllMethods(String dependencyId) {

        Dependency dependency = dependencyRepository.findDependencyById(dependencyId);
        template.fetch(dependency.getMethods());
        return DTOTransformerUtil.transformMethodSetToMethodsDTO(dependency.getMethods());
    }

    @Override
    public MethodDTO findMethod(String dependencyId, String methodId) {

        Dependency dependency = dependencyRepository.findDependencyById(dependencyId);
        template.fetch(dependency.getMethods());
        Method method = null;

        for(Method e : dependency.getMethods()){
            if(e.getTeriansId().equals(methodId)){
                method = e;
                break;
            }
        }
        return DTOTransformerUtil.transformMethodToMethodDTO(method);
    }

    @Override
    public DependenciesDTO findAllRelatedDependencies(String dependencyId) {

        Dependency dependency = dependencyRepository.findDependencyById(dependencyId);
        template.fetch(dependency.getDependencies());

        return DTOTransformerUtil.transformDependencySetToDependenciesDTO(dependency.getDependencies());
    }

    @Override
    public DependencyDTO findRelatedDependency(String dependencyId, String relatedDependencyId) {

        Dependency dependency = dependencyRepository.findDependencyById(dependencyId);
        template.fetch(dependency.getDependencies());
        Dependency relatedDependency = null;

        for(Dependency e : dependency.getDependencies()){
            if(e.getTeriansId().equals(relatedDependencyId)){
                relatedDependency = e;
                break;
            }
        }

        return DTOTransformerUtil.transformDependencyToDependencyDTO(relatedDependency);
    }

    @Override
    public VulnerabilitiesDTO findAllVulnerabilities(String dependencyId) {

        Dependency dependency = dependencyRepository.findDependencyById(dependencyId);
        template.fetch(dependency.getVulnerabilities());

        return DTOTransformerUtil.transformVulnerabilitySetToVulnerabilitiesDTO(dependency.getVulnerabilities());
    }

    @Override
    public VulnerabilityDTO findVulnerability(String dependencyId, String vulnerabilityId) {

        Dependency dependency = dependencyRepository.findDependencyById(dependencyId);
        template.fetch(dependency.getVulnerabilities());
        Vulnerability vulnerability = null;
        for(Vulnerability e : dependency.getVulnerabilities()){
            if(e.getTeriansId().equals(vulnerabilityId)){
                vulnerability = e;
                break;
            }
        }

        return DTOTransformerUtil.transformVulnerabilityToVulnerabilityDTO(vulnerability);
    }

    @Override
    public IssuesDTO findAllIssues(String id, String category, String dependencyId) {
        return null;
    }

    @Override
    public IssueDTO findIssue(String dependencyId,String issueId) {

        Dependency dependency = dependencyRepository.findDependencyById(dependencyId);
        template.fetch(dependency.getIssues());
        Issue issue = null;
        for(Issue e : dependency.getIssues()){
            if(e.getTeriansId().equals(issueId)){
                issue = e;
                break;
            }
        }
        return DTOTransformerUtil.transformIssueToIssueDTO(issue);
    }


}
