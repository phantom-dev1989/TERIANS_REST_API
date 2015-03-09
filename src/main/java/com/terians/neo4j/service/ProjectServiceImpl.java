package com.terians.neo4j.service;


import com.terians.dto.*;
import com.terians.dto.transformer.DTOTransformerUtil;
import com.terians.neo4j.model.*;
import com.terians.neo4j.model.Package;
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
    public ProjectDTO findProject(String projectId) {
        return DTOTransformerUtil.transformProjectToProjectDTO(projectRepository.findProjectById(projectId));
    }

    @Override
    public ScansDTO findAllScans(String projectId) {

        Project project = projectRepository.findProjectById(projectId);
        template.fetch(project.getScans());

        return DTOTransformerUtil.transformScanSetToScansDTO(project.getScans());
    }

    @Override
    public ScanDTO findScan(String projectId, String scanId, String metric, String scanned) {

        Project project = projectRepository.findProjectById(projectId);
        template.fetch(project.getScans());
        Scan scan = null;
        for(Scan e : project.getScans()){
            if(e.getTeriansId().equals(scanId)){
                scan = e;
                break;
            }
        }
        return DTOTransformerUtil.transformScanToScanDTO(scan);
    }

    @Override
    public IssuesDTO findAllIssues(String projectId, String scanId, String category, String orderedBy) {

        Project project = projectRepository.findProjectById(projectId);
        template.fetch(project.getScans());
        Scan scan = null;
        for(Scan e : project.getScans()){
            if(e.getTeriansId().equals(scanId)){
                scan = e;
                template.fetch(scan.getIssues());
                break;
            }
        }
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(scan.getIssues());
    }

    @Override
    public IssueDTO findIssue(String projectId, String scanId, String issueId) {

        Project project = projectRepository.findProjectById(projectId);
        template.fetch(project.getScans());
        Scan scan = null;
        Issue issue = null;
        for(Scan e : project.getScans()){
            if(e.getTeriansId().equals(scanId)){
                scan = e;
                template.fetch(scan.getIssues());
                for(Issue e1 : scan.getIssues()){
                    if(e1.getTeriansId().equals(issueId)){
                        issue = e1;
                        break;
                    }
                }
                break;
            }
        }
        return DTOTransformerUtil.transformIssueToIssueDTO(issue);
    }

    @Override
    public DependenciesDTO findAllDependencies(String projectId, String scanId) {

        Project project = projectRepository.findProjectById(projectId);
        template.fetch(project.getScans());
        Scan scan = null;
        for(Scan e : project.getScans()){
            if(e.getTeriansId().equals(scanId)){
                scan = e;
                template.fetch(scan.getDependencies());
                break;
            }
        }
        return DTOTransformerUtil.transformDependencySetToDependenciesDTO(scan.getDependencies());
    }

    @Override
    public DependencyDTO findDependeny(String projectId, String scanId, String dependencyId) {

        Project project = projectRepository.findProjectById(projectId);
        template.fetch(project.getScans());
        Scan scan = null;
        Dependency dependency = null;
        for(Scan e : project.getScans()){
            if(e.getTeriansId().equals(scanId)){
                scan = e;
                template.fetch(scan.getDependencies());
                for(Dependency e1 : scan.getDependencies()){
                    if(e1.getTeriansId().equals(dependencyId)){
                        dependency = e1;
                        break;
                    }
                }
                break;
            }
        }
        return DTOTransformerUtil.transformDependencyToDependencyDTO(dependency);
    }

    @Override
    public MethodsDTO findAllDependenyMethods(String projectId, String scanId, String dependencyId) {

        Project project = projectRepository.findProjectById(projectId);
        template.fetch(project.getScans());
        Scan scan = null;
        Dependency dependency = null;
        for(Scan e : project.getScans()){
            if(e.getTeriansId().equals(scanId)){
                scan = e;
                template.fetch(scan.getDependencies());
                for(Dependency e1 : scan.getDependencies()){
                    if(e1.getTeriansId().equals(dependencyId)){
                        dependency = e1;
                        template.fetch(dependency.getMethods());
                        break;
                    }
                }
                break;
            }
        }
        return DTOTransformerUtil.transformMethodSetToMethodsDTO(dependency.getMethods());
    }

    @Override
    public MethodDTO findDependenyMethod(String projectId, String scanId, String dependencyId, String methodId) {

        Project project = projectRepository.findProjectById(projectId);
        template.fetch(project.getScans());
        Scan scan = null;
        Dependency dependency = null;
        Method method = null;
        for(Scan e : project.getScans()){
            if(e.getTeriansId().equals(scanId)){
                scan = e;
                template.fetch(scan.getDependencies());
                for(Dependency e1 : scan.getDependencies()){
                    if(e1.getTeriansId().equals(dependencyId)){
                        dependency = e1;
                        template.fetch(dependency.getMethods());
                        for(Method e2 : dependency.getMethods()){
                            if(e2.getTeriansId().equals(methodId)){
                                method = e2;
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }
        return DTOTransformerUtil.transformMethodToMethodDTO(method);
    }

    @Override
    public DependenciesDTO findAllRelatedDependencies(String projectId, String scanId, String dependencyId) {

        Project project = projectRepository.findProjectById(projectId);
        template.fetch(project.getScans());
        Scan scan = null;
        Dependency dependency = null;
        for(Scan e : project.getScans()){
            if(e.getTeriansId().equals(scanId)){
                scan = e;
                template.fetch(scan.getDependencies());
                for(Dependency e1 : scan.getDependencies()){
                    if(e1.getTeriansId().equals(dependencyId)){
                        dependency = e1;
                        template.fetch(dependency.getDependencies());
                        break;
                    }
                }
                break;
            }
        }
        return DTOTransformerUtil.transformDependencySetToDependenciesDTO(dependency.getDependencies());
    }

    @Override
    public DependencyDTO findRelatedDependency(String projectId, String scanId, String dependencyId, String relatedDependencyId) {

        Project project = projectRepository.findProjectById(projectId);
        template.fetch(project.getScans());
        Scan scan = null;
        Dependency dependency = null;
        Dependency relatedDependency = null;
        for(Scan e : project.getScans()){
            if(e.getTeriansId().equals(scanId)){
                scan = e;
                template.fetch(scan.getDependencies());
                for(Dependency e1 : scan.getDependencies()){
                    if(e1.getTeriansId().equals(dependencyId)){
                        dependency = e1;
                        template.fetch(dependency.getDependencies());
                        for(Dependency e2 : dependency.getDependencies()){
                            if(e2.getTeriansId().equals(relatedDependencyId)){
                                relatedDependency = e2;
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }
        return DTOTransformerUtil.transformDependencyToDependencyDTO(relatedDependency);
    }

    @Override
    public VulnerabilitiesDTO findAllVulnerabilities(String projectId, String scanId, String dependencyId) {

        Project project = projectRepository.findProjectById(projectId);
        template.fetch(project.getScans());
        Scan scan = null;
        Dependency dependency = null;
        for(Scan e : project.getScans()){
            if(e.getTeriansId().equals(scanId)){
                scan = e;
                template.fetch(scan.getDependencies());
                for(Dependency e1 : scan.getDependencies()){
                    if(e1.getTeriansId().equals(dependencyId)){
                        dependency = e1;
                        template.fetch(dependency.getVulnerabilities());
                        break;
                    }
                }
                break;
            }
        }
        return DTOTransformerUtil.transformVulnerabilitySetToVulnerabilitiesDTO(dependency.getVulnerabilities());
    }

    @Override
    public VulnerabilityDTO findVulnerability(String projectId, String scanId, String dependencyId, String vulnerabilityId) {

        Project project = projectRepository.findProjectById(projectId);
        template.fetch(project.getScans());
        Scan scan = null;
        Dependency dependency = null;
        Vulnerability vulnerability = null;
        for(Scan e : project.getScans()){
            if(e.getTeriansId().equals(scanId)){
                scan = e;
                template.fetch(scan.getDependencies());
                for(Dependency e1 : scan.getDependencies()){
                    if(e1.getTeriansId().equals(dependencyId)){
                        dependency = e1;
                        template.fetch(dependency.getVulnerabilities());
                        for(Vulnerability e2 : dependency.getVulnerabilities() ){
                            if(e2.getTeriansId().equals(vulnerabilityId)){
                                vulnerability = e2;
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }
        return DTOTransformerUtil.transformVulnerabilityToVulnerabilityDTO(vulnerability);
    }

    @Override
    public IssuesDTO findAllDependencyIssues(String projectId, String scanId, String dependencyId, String category, String orderedBy) {

        Project project = projectRepository.findProjectById(projectId);
        template.fetch(project.getScans());
        Scan scan = null;
        Dependency dependency = null;
        for(Scan e : project.getScans()){
            if(e.getTeriansId().equals(scanId)){
                scan = e;
                template.fetch(scan.getDependencies());
                for(Dependency e1 : scan.getDependencies()){
                    if(e1.getTeriansId().equals(dependencyId)){
                        dependency = e1;
                        template.fetch(dependency.getIssues());
                        break;
                    }
                }
                break;
            }
        }
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(dependency.getIssues());
    }

    @Override
    public IssueDTO findDependencyIssue(String projectId, String scanId, String dependencyId, String issueId) {

        Project project = projectRepository.findProjectById(projectId);
        template.fetch(project.getScans());
        Scan scan = null;
        Dependency dependency = null;
        Issue issue = null;
        for(Scan e : project.getScans()){
            if(e.getTeriansId().equals(scanId)){
                scan = e;
                template.fetch(scan.getDependencies());
                for(Dependency e1 : scan.getDependencies()){
                    if(e1.getTeriansId().equals(dependencyId)){
                        dependency = e1;
                        template.fetch(dependency.getIssues());
                        for(Issue e2 : dependency.getIssues()){
                            if(e2.getTeriansId().equals(issueId)){
                                issue = e2;
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }
        return DTOTransformerUtil.transformIssueToIssueDTO(issue);
    }

    @Override
    public PackagesDTO findAllPackages(String projectId, String scanId) {

        Project project = projectRepository.findProjectById(projectId);
        template.fetch(project.getScans());
        Scan scan = null;
        for(Scan e : project.getScans()){
            if(e.getTeriansId().equals(scanId)){
                scan = e;
                template.fetch(scan.getPackages());
                break;
            }
        }
        return DTOTransformerUtil.transformPackageSetToPackagesDTO(scan.getPackages());
    }

    @Override
    public PackageDTO findPackage(String projectId, String scanId, String packageId) {

        Project project = projectRepository.findProjectById(projectId);
        template.fetch(project.getScans());
        Scan scan = null;
        Package packageObj = null;
        for(Scan e : project.getScans()){
            if(e.getTeriansId().equals(scanId)){
                scan = e;
                template.fetch(scan.getPackages());
                for(Package e1: scan.getPackages()){
                    if(e.getTeriansId().equals(packageId)){
                        packageObj = e1;
                        break;
                    }
                }
                break;
            }
        }
        return DTOTransformerUtil.transformPackageToPackageDTO(packageObj);
    }

    @Override
    public ClazzesDTO findAllClazzes(String projectId, String scanId, String packageId) {

        Project project = projectRepository.findProjectById(projectId);
        template.fetch(project.getScans());
        Scan scan = null;
        Package packageObj = null;
        for(Scan e : project.getScans()){
            if(e.getTeriansId().equals(scanId)){
                scan = e;
                template.fetch(scan.getPackages());
                for(Package e1: scan.getPackages()){
                    if(e.getTeriansId().equals(packageId)){
                        packageObj = e1;
                        template.fetch(packageObj.getClazzs());
                        break;
                    }
                }
                break;
            }
        }
        return DTOTransformerUtil.transformClazzSetToClazzesDTO(packageObj.getClazzs());
    }

    @Override
    public ClazzDTO findClazz(String projectId, String scanId, String packageId, String clazzId) {

        Project project = projectRepository.findProjectById(projectId);
        template.fetch(project.getScans());
        Scan scan = null;
        Package packageObj = null;
        Clazz clazz = null;
        for(Scan e : project.getScans()){
            if(e.getTeriansId().equals(scanId)){
                scan = e;
                template.fetch(scan.getPackages());
                for(Package e1: scan.getPackages()){
                    if(e.getTeriansId().equals(packageId)){
                        packageObj = e1;
                        template.fetch(packageObj.getClazzs());
                        for(Clazz e2 : packageObj.getClazzs()){
                            if(e2.getTeriansId().equals(clazzId)){
                                clazz = e2;
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }
        return DTOTransformerUtil.transformClazzToClazzDTO(clazz);
    }

    @Override
    public MethodsDTO findAllMethods(String projectId, String scanId, String packageId, String clazzId) {

        Project project = projectRepository.findProjectById(projectId);
        template.fetch(project.getScans());
        Scan scan = null;
        Package packageObj = null;
        Clazz clazz = null;
        for(Scan e : project.getScans()){
            if(e.getTeriansId().equals(scanId)){
                scan = e;
                template.fetch(scan.getPackages());
                for(Package e1: scan.getPackages()){
                    if(e.getTeriansId().equals(packageId)){
                        packageObj = e1;
                        template.fetch(packageObj.getClazzs());
                        for(Clazz e2 : packageObj.getClazzs()){
                            if(e2.getTeriansId().equals(clazzId)){
                                clazz = e2;
                                template.fetch(clazz.getMethods());
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }
        return DTOTransformerUtil.transformMethodSetToMethodsDTO(clazz.getMethods());
    }

    @Override
    public MethodDTO findMethod(String projectId, String scanId, String packageId, String clazzId, String methodId) {

        Project project = projectRepository.findProjectById(projectId);
        template.fetch(project.getScans());
        Scan scan = null;
        Package packageObj = null;
        Clazz clazz = null;
        Method method = null;
        for(Scan e : project.getScans()){
            if(e.getTeriansId().equals(scanId)){
                scan = e;
                template.fetch(scan.getPackages());
                for(Package e1: scan.getPackages()){
                    if(e.getTeriansId().equals(packageId)){
                        packageObj = e1;
                        template.fetch(packageObj.getClazzs());
                        for(Clazz e2 : packageObj.getClazzs()){
                            if(e2.getTeriansId().equals(clazzId)){
                                clazz = e2;
                                template.fetch(clazz.getMethods());
                                for(Method e3 : clazz.getMethods()){
                                    method = e3;
                                    break;
                                }
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }
        return DTOTransformerUtil.transformMethodToMethodDTO(method);
    }
}
