package com.terians.neo4j.service;


import com.terians.dto.*;
import com.terians.dto.transformer.DTOTransformerUtil;
import com.terians.neo4j.model.*;
import com.terians.neo4j.model.Package;
import com.terians.neo4j.repository.ProjectRepository;
import com.terians.neo4j.repository.ScanRepository;
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
    @Autowired
    private ScanRepository scanRepository;


    @Override
    public ProjectsDTO findAllProjects() {
        return DTOTransformerUtil.transformProjectSetToProjectsDTO(projectRepository.findAllProjects());
    }

    @Override
    public ProjectDTO findProject(String projectId) {

        if (projectId != null) {
            return DTOTransformerUtil.transformProjectToProjectDTO(projectRepository.findProjectById(projectId));
        }
        return null;
    }

    @Override
    public ScansDTO findAllScans(String projectId) {

        if (projectId != null) {
            Project project = projectRepository.findProjectById(projectId);
            template.fetch(project.getScans());
            return DTOTransformerUtil.transformScanSetToScansDTO(project.getScans());
        }
        return null;
    }

    @Override
    public ScanDTO findScan(String projectId, String scanId, String scanned) {

        ScanDTO scanDTO = null;

        if ((projectId != null) && (scanId != null)) {

            if (scanned == null) {

                Project project = projectRepository.findProjectById(projectId);
                template.fetch(project.getScans());
                Scan scan = null;
                for (Scan e : project.getScans()) {
                    if (e.getTeriansId().equals(scanId)) {
                        scan = e;
                        break;
                    }
                }

                scanDTO = DTOTransformerUtil.transformScanToScanDTO(scan);
                scanDTO.setAbstractness(scanRepository.findAbstractnessByScan(scanId));
                scanDTO.setClazzCount(scanRepository.findClazzCountByScan(scanId));
                scanDTO.setComplexity(scanRepository.findComplexityByScan(scanId));
                scanDTO.setInstability(scanRepository.findInstabilityByScan(scanId));
                scanDTO.setMethodCount(scanRepository.findMethodCountByScan(scanId));
                scanDTO.setPackageCount(scanRepository.findPackageCountByScan(scanId));
                scanDTO.setTechdebt(scanRepository.findTechDebtByScan(scanId));
                scanDTO.setIssueCount(scanRepository.findIssueCountByScan(scanId));
                return scanDTO;

            } else if (scanned.equals("last")) {

                scanDTO = DTOTransformerUtil.transformScanToScanDTO(scanRepository.findLatestScan());
                scanDTO.setAbstractness(scanRepository.findAbstractnessByScan(scanDTO.getTeriansId()));
                scanDTO.setClazzCount(scanRepository.findClazzCountByScan(scanDTO.getTeriansId()));
                scanDTO.setComplexity(scanRepository.findComplexityByScan(scanDTO.getTeriansId()));
                scanDTO.setInstability(scanRepository.findInstabilityByScan(scanDTO.getTeriansId()));
                scanDTO.setMethodCount(scanRepository.findMethodCountByScan(scanDTO.getTeriansId()));
                scanDTO.setPackageCount(scanRepository.findPackageCountByScan(scanDTO.getTeriansId()));
                scanDTO.setTechdebt(scanRepository.findTechDebtByScan(scanDTO.getTeriansId()));
                scanDTO.setIssueCount(scanRepository.findIssueCountByScan(scanDTO.getTeriansId()));
                return scanDTO;

            } else if (scanned.equals("first")) {

                scanDTO = DTOTransformerUtil.transformScanToScanDTO(scanRepository.findOldestScan());
                scanDTO.setAbstractness(scanRepository.findAbstractnessByScan(scanDTO.getTeriansId()));
                scanDTO.setClazzCount(scanRepository.findClazzCountByScan(scanDTO.getTeriansId()));
                scanDTO.setComplexity(scanRepository.findComplexityByScan(scanDTO.getTeriansId()));
                scanDTO.setInstability(scanRepository.findInstabilityByScan(scanDTO.getTeriansId()));
                scanDTO.setMethodCount(scanRepository.findMethodCountByScan(scanDTO.getTeriansId()));
                scanDTO.setPackageCount(scanRepository.findPackageCountByScan(scanDTO.getTeriansId()));
                scanDTO.setTechdebt(scanRepository.findTechDebtByScan(scanDTO.getTeriansId()));
                scanDTO.setIssueCount(scanRepository.findIssueCountByScan(scanDTO.getTeriansId()));
                return scanDTO;

            }
        }
        return null;
    }

    @Override
    public IssuesDTO findAllIssues(String projectId, String scanId) {

        if ((projectId != null) && (scanId != null)) {
            Project project = projectRepository.findProjectById(projectId);
            template.fetch(project.getScans());
            Scan scan = null;
            for (Scan e : project.getScans()) {
                if (e.getTeriansId().equals(scanId)) {
                    scan = e;
                    template.fetch(scan.getIssues());
                    break;
                }
            }
            return DTOTransformerUtil.transformIssuesSetToIssuesDTO(scan.getIssues());
        }
        return null;
    }

    @Override
    public IssueDTO findIssue(String projectId, String scanId, String issueId) {

        if ((projectId != null) && (scanId != null) && (issueId != null)) {
            Project project = projectRepository.findProjectById(projectId);
            template.fetch(project.getScans());
            Scan scan = null;
            Issue issue = null;
            for (Scan e : project.getScans()) {
                if (e.getTeriansId().equals(scanId)) {
                    scan = e;
                    template.fetch(scan.getIssues());
                    for (Issue e1 : scan.getIssues()) {
                        if (e1.getTeriansId().equals(issueId)) {
                            issue = e1;
                            break;
                        }
                    }
                    break;
                }
            }
            return DTOTransformerUtil.transformIssueToIssueDTO(issue);
        }
        return null;
    }

    @Override
    public DependenciesDTO findAllDependencies(String projectId, String scanId) {

        if ((projectId != null) && (scanId != null)) {
            Project project = projectRepository.findProjectById(projectId);
            template.fetch(project.getScans());
            Scan scan = null;
            for (Scan e : project.getScans()) {
                if (e.getTeriansId().equals(scanId)) {
                    scan = e;
                    template.fetch(scan.getDependencies());
                    break;
                }
            }
            return DTOTransformerUtil.transformDependencySetToDependenciesDTO(scan.getDependencies());
        }
        return null;
    }

    @Override
    public DependencyDTO findDependeny(String projectId, String scanId, String dependencyId) {

        if ((projectId != null) && (scanId != null) && (dependencyId != null)) {
            Project project = projectRepository.findProjectById(projectId);
            template.fetch(project.getScans());
            Scan scan = null;
            Dependency dependency = null;
            for (Scan e : project.getScans()) {
                if (e.getTeriansId().equals(scanId)) {
                    scan = e;
                    template.fetch(scan.getDependencies());
                    for (Dependency e1 : scan.getDependencies()) {
                        if (e1.getTeriansId().equals(dependencyId)) {
                            dependency = e1;
                            break;
                        }
                    }
                    break;
                }
            }
            return DTOTransformerUtil.transformDependencyToDependencyDTO(dependency);
        }
        return null;
    }

    @Override
    public MethodsDTO findAllDependenyMethods(String projectId, String scanId, String dependencyId) {

        if ((projectId != null) && (scanId != null) && (dependencyId != null)) {
            Project project = projectRepository.findProjectById(projectId);
            template.fetch(project.getScans());
            Scan scan = null;
            Dependency dependency = null;
            for (Scan e : project.getScans()) {
                if (e.getTeriansId().equals(scanId)) {
                    scan = e;
                    template.fetch(scan.getDependencies());
                    for (Dependency e1 : scan.getDependencies()) {
                        if (e1.getTeriansId().equals(dependencyId)) {
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
        return null;
    }

    @Override
    public MethodDTO findDependenyMethod(String projectId, String scanId, String dependencyId, String methodId) {

        if ((projectId != null) && (scanId != null) && (dependencyId != null) && (methodId != null)) {
            Project project = projectRepository.findProjectById(projectId);
            template.fetch(project.getScans());
            Scan scan = null;
            Dependency dependency = null;
            Method method = null;
            for (Scan e : project.getScans()) {
                if (e.getTeriansId().equals(scanId)) {
                    scan = e;
                    template.fetch(scan.getDependencies());
                    for (Dependency e1 : scan.getDependencies()) {
                        if (e1.getTeriansId().equals(dependencyId)) {
                            dependency = e1;
                            template.fetch(dependency.getMethods());
                            for (Method e2 : dependency.getMethods()) {
                                if (e2.getTeriansId().equals(methodId)) {
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
        return null;
    }

    @Override
    public DependenciesDTO findAllRelatedDependencies(String projectId, String scanId, String dependencyId) {

        if ((projectId != null) && (scanId != null) && (dependencyId != null)) {
            Project project = projectRepository.findProjectById(projectId);
            template.fetch(project.getScans());
            Scan scan = null;
            Dependency dependency = null;
            for (Scan e : project.getScans()) {
                if (e.getTeriansId().equals(scanId)) {
                    scan = e;
                    template.fetch(scan.getDependencies());
                    for (Dependency e1 : scan.getDependencies()) {
                        if (e1.getTeriansId().equals(dependencyId)) {
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
        return null;
    }

    @Override
    public DependencyDTO findRelatedDependency(String projectId, String scanId, String dependencyId, String relatedDependencyId) {

        if ((projectId != null) && (scanId != null) && (dependencyId != null) && (relatedDependencyId != null)) {
            Project project = projectRepository.findProjectById(projectId);
            template.fetch(project.getScans());
            Scan scan = null;
            Dependency dependency = null;
            Dependency relatedDependency = null;
            for (Scan e : project.getScans()) {
                if (e.getTeriansId().equals(scanId)) {
                    scan = e;
                    template.fetch(scan.getDependencies());
                    for (Dependency e1 : scan.getDependencies()) {
                        if (e1.getTeriansId().equals(dependencyId)) {
                            dependency = e1;
                            template.fetch(dependency.getDependencies());
                            for (Dependency e2 : dependency.getDependencies()) {
                                if (e2.getTeriansId().equals(relatedDependencyId)) {
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
        return null;
    }

    @Override
    public VulnerabilitiesDTO findAllVulnerabilities(String projectId, String scanId, String dependencyId) {

        if ((projectId != null) && (scanId != null) && (dependencyId != null)) {
            Project project = projectRepository.findProjectById(projectId);
            template.fetch(project.getScans());
            Scan scan = null;
            Dependency dependency = null;
            for (Scan e : project.getScans()) {
                if (e.getTeriansId().equals(scanId)) {
                    scan = e;
                    template.fetch(scan.getDependencies());
                    for (Dependency e1 : scan.getDependencies()) {
                        if (e1.getTeriansId().equals(dependencyId)) {
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
        return null;
    }

    @Override
    public VulnerabilityDTO findVulnerability(String projectId, String scanId, String dependencyId, String vulnerabilityId) {

        if ((projectId != null) && (scanId != null) && (dependencyId != null) && (vulnerabilityId != null)) {
            Project project = projectRepository.findProjectById(projectId);
            template.fetch(project.getScans());
            Scan scan = null;
            Dependency dependency = null;
            Vulnerability vulnerability = null;
            for (Scan e : project.getScans()) {
                if (e.getTeriansId().equals(scanId)) {
                    scan = e;
                    template.fetch(scan.getDependencies());
                    for (Dependency e1 : scan.getDependencies()) {
                        if (e1.getTeriansId().equals(dependencyId)) {
                            dependency = e1;
                            template.fetch(dependency.getVulnerabilities());
                            for (Vulnerability e2 : dependency.getVulnerabilities()) {
                                if (e2.getTeriansId().equals(vulnerabilityId)) {
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
        return null;
    }

    @Override
    public IssuesDTO findAllDependencyIssues(String projectId, String scanId, String dependencyId) {

        if ((projectId != null) && (scanId != null) && (dependencyId != null)) {
            Project project = projectRepository.findProjectById(projectId);
            template.fetch(project.getScans());
            Scan scan = null;
            Dependency dependency = null;
            for (Scan e : project.getScans()) {
                if (e.getTeriansId().equals(scanId)) {
                    scan = e;
                    template.fetch(scan.getDependencies());
                    for (Dependency e1 : scan.getDependencies()) {
                        if (e1.getTeriansId().equals(dependencyId)) {
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
        return null;
    }

    @Override
    public IssueDTO findDependencyIssue(String projectId, String scanId, String dependencyId, String issueId) {

        if ((projectId != null) && (scanId != null) && (dependencyId != null) && (issueId != null)) {
            Project project = projectRepository.findProjectById(projectId);
            template.fetch(project.getScans());
            Scan scan = null;
            Dependency dependency = null;
            Issue issue = null;
            for (Scan e : project.getScans()) {
                if (e.getTeriansId().equals(scanId)) {
                    scan = e;
                    template.fetch(scan.getDependencies());
                    for (Dependency e1 : scan.getDependencies()) {
                        if (e1.getTeriansId().equals(dependencyId)) {
                            dependency = e1;
                            template.fetch(dependency.getIssues());
                            for (Issue e2 : dependency.getIssues()) {
                                if (e2.getTeriansId().equals(issueId)) {
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
        return null;
    }

    @Override
    public PackagesDTO findAllPackages(String projectId, String scanId) {

        if ((projectId != null) && (scanId != null)) {
            Project project = projectRepository.findProjectById(projectId);
            template.fetch(project.getScans());
            Scan scan = null;
            for (Scan e : project.getScans()) {
                if (e.getTeriansId().equals(scanId)) {
                    scan = e;
                    template.fetch(scan.getPackages());
                    break;
                }
            }
            return DTOTransformerUtil.transformPackageSetToPackagesDTO(scan.getPackages());
        }
        return null;
    }

    @Override
    public PackageDTO findPackage(String projectId, String scanId, String packageId) {

        if ((projectId != null) && (scanId != null) && (packageId != null)) {
            Project project = projectRepository.findProjectById(projectId);
            template.fetch(project.getScans());
            Scan scan = null;
            Package packageObj = null;
            for (Scan e : project.getScans()) {
                if (e.getTeriansId().equals(scanId)) {
                    scan = e;
                    template.fetch(scan.getPackages());
                    for (Package e1 : scan.getPackages()) {
                        if (e.getTeriansId().equals(packageId)) {
                            packageObj = e1;
                            break;
                        }
                    }
                    break;
                }
            }
            return DTOTransformerUtil.transformPackageToPackageDTO(packageObj);
        }
        return null;
    }

    @Override
    public ClazzesDTO findAllClazzes(String projectId, String scanId, String packageId) {

        if ((projectId != null) && (scanId != null) && (packageId != null)) {
            Project project = projectRepository.findProjectById(projectId);
            template.fetch(project.getScans());
            Scan scan = null;
            Package packageObj = null;
            for (Scan e : project.getScans()) {
                if (e.getTeriansId().equals(scanId)) {
                    scan = e;
                    template.fetch(scan.getPackages());
                    for (Package e1 : scan.getPackages()) {
                        if (e.getTeriansId().equals(packageId)) {
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
        return null;
    }

    @Override
    public ClazzDTO findClazz(String projectId, String scanId, String packageId, String clazzId) {

        if ((projectId != null) && (scanId != null) && (packageId != null) && (clazzId != null)) {
            Project project = projectRepository.findProjectById(projectId);
            template.fetch(project.getScans());
            Scan scan = null;
            Package packageObj = null;
            Clazz clazz = null;
            for (Scan e : project.getScans()) {
                if (e.getTeriansId().equals(scanId)) {
                    scan = e;
                    template.fetch(scan.getPackages());
                    for (Package e1 : scan.getPackages()) {
                        if (e.getTeriansId().equals(packageId)) {
                            packageObj = e1;
                            template.fetch(packageObj.getClazzs());
                            for (Clazz e2 : packageObj.getClazzs()) {
                                if (e2.getTeriansId().equals(clazzId)) {
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
        return null;
    }

    @Override
    public MethodsDTO findAllMethods(String projectId, String scanId, String packageId, String clazzId) {

        if ((projectId != null) && (scanId != null) && (packageId != null) && (clazzId != null)) {
            Project project = projectRepository.findProjectById(projectId);
            template.fetch(project.getScans());
            Scan scan = null;
            Package packageObj = null;
            Clazz clazz = null;
            for (Scan e : project.getScans()) {
                if (e.getTeriansId().equals(scanId)) {
                    scan = e;
                    template.fetch(scan.getPackages());
                    for (Package e1 : scan.getPackages()) {
                        if (e.getTeriansId().equals(packageId)) {
                            packageObj = e1;
                            template.fetch(packageObj.getClazzs());
                            for (Clazz e2 : packageObj.getClazzs()) {
                                if (e2.getTeriansId().equals(clazzId)) {
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
        return null;
    }

    @Override
    public MethodDTO findMethod(String projectId, String scanId, String packageId, String clazzId, String methodId) {

        if ((projectId != null) && (scanId != null) && (packageId != null) && (clazzId != null) && (methodId != null)) {
            Project project = projectRepository.findProjectById(projectId);
            template.fetch(project.getScans());
            Scan scan = null;
            Package packageObj = null;
            Clazz clazz = null;
            Method method = null;
            for (Scan e : project.getScans()) {
                if (e.getTeriansId().equals(scanId)) {
                    scan = e;
                    template.fetch(scan.getPackages());
                    for (Package e1 : scan.getPackages()) {
                        if (e.getTeriansId().equals(packageId)) {
                            packageObj = e1;
                            template.fetch(packageObj.getClazzs());
                            for (Clazz e2 : packageObj.getClazzs()) {
                                if (e2.getTeriansId().equals(clazzId)) {
                                    clazz = e2;
                                    template.fetch(clazz.getMethods());
                                    for (Method e3 : clazz.getMethods()) {
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
        return null;
    }
}
