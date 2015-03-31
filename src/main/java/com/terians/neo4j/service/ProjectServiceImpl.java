package com.terians.neo4j.service;

import com.terians.dto.*;
import com.terians.dto.transformer.DTOTransformerUtil;
import com.terians.neo4j.repository.ProjectRepository;
import com.terians.neo4j.repository.ScanRepository;
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
    private ProjectRepository projectRepository;
    @Autowired
    private ScanRepository scanRepository;

    @Override
    public ProjectsDTO findAllProjects() {
        return DTOTransformerUtil
                .transformProjectSetToProjectsDTO(projectRepository
                        .findAllProjects());
    }

    @Override
    public ProjectDTO findProject(String projectId) {

        if (projectId != null) {
            return DTOTransformerUtil
                    .transformProjectToProjectDTO(projectRepository
                            .findProject(projectId));
        }
        return null;
    }

    @Override
    public ScansDTO findAllScans(String projectId) {

        if (projectId != null) {
            return DTOTransformerUtil
                    .transformScanSetToScansDTO(projectRepository
                            .findAllScans(projectId));
        }
        return null;
    }

    @Override
    public ScanDTO findScan(String projectId, String scanId) {

        ScanDTO scanDTO;

        if ((projectId != null) && (scanId != null)) {

            scanDTO = DTOTransformerUtil
                    .transformScanToScanDTO(projectRepository.findScan(
                            projectId, scanId));
            scanDTO.setAbstractness(scanRepository
                    .findAbstractnessByScan(scanId));
            scanDTO.setClazzCount(scanRepository
                    .findClazzCountByScan(scanId));
            scanDTO.setComplexity(scanRepository
                    .findComplexityByScan(scanId));
            scanDTO.setInstability(scanRepository
                    .findInstabilityByScan(scanId));
            scanDTO.setMethodCount(scanRepository
                    .findMethodCountByScan(scanId));
            scanDTO.setPackageCount(scanRepository
                    .findPackageCountByScan(scanId));
            scanDTO.setTechdebt(scanRepository.findTechDebtByScan(scanId));
            scanDTO.setIssueCount(scanRepository
                    .findIssueCountByScan(scanId));
            return scanDTO;
        }
        return null;
    }

    @Override
    public IssuesDTO findAllIssues(String projectId, String scanId) {

        if ((projectId != null) && (scanId != null)) {
            return DTOTransformerUtil
                    .transformIssuesSetToIssuesDTO(projectRepository
                            .findAllIssues(projectId, scanId));
        }
        return null;
    }

    @Override
    public IssueDTO findIssue(String projectId, String scanId, String issueId) {

        if ((projectId != null) && (scanId != null) && (issueId != null)) {
            return DTOTransformerUtil
                    .transformIssueToIssueDTO(projectRepository.findIssue(
                            projectId, scanId, issueId));
        }
        return null;
    }

    @Override
    public DependenciesDTO findAllDependencies(String projectId, String scanId) {

        if ((projectId != null) && (scanId != null)) {
            return DTOTransformerUtil
                    .transformDependencySetToDependenciesDTO(projectRepository
                            .findAllDependencies(projectId, scanId));
        }
        return null;
    }

    @Override
    public DependencyDTO findDependeny(String projectId, String scanId,
                                       String dependencyId) {

        if ((projectId != null) && (scanId != null) && (dependencyId != null)) {
            return DTOTransformerUtil
                    .transformDependencyToDependencyDTO(projectRepository
                            .findDependency(projectId, scanId, dependencyId));
        }
        return null;
    }

    @Override
    public MethodsDTO findAllDependenyMethods(String projectId, String scanId,
                                              String dependencyId) {

        if ((projectId != null) && (scanId != null) && (dependencyId != null)) {
            return DTOTransformerUtil
                    .transformMethodSetToMethodsDTO(projectRepository
                            .findAllDependencyMethods(projectId, scanId,
                                    dependencyId));
        }
        return null;
    }

    @Override
    public MethodDTO findDependenyMethod(String projectId, String scanId,
                                         String dependencyId, String methodId) {

        if ((projectId != null) && (scanId != null) && (dependencyId != null)
                && (methodId != null)) {
            return DTOTransformerUtil
                    .transformMethodToMethodDTO(projectRepository
                            .findDependencyMethod(projectId, scanId,
                                    dependencyId, methodId));
        }
        return null;
    }

    @Override
    public DependenciesDTO findAllRelatedDependencies(String projectId,
                                                      String scanId, String dependencyId) {

        if ((projectId != null) && (scanId != null) && (dependencyId != null)) {
            return DTOTransformerUtil
                    .transformDependencySetToDependenciesDTO(projectRepository
                            .findAllRelatedDependencies(projectId, scanId,
                                    dependencyId));
        }
        return null;
    }

    @Override
    public DependencyDTO findRelatedDependency(String projectId, String scanId,
                                               String dependencyId, String relatedDependencyId) {

        if ((projectId != null) && (scanId != null) && (dependencyId != null)
                && (relatedDependencyId != null)) {
            return DTOTransformerUtil
                    .transformDependencyToDependencyDTO(projectRepository
                            .findRelatedDependency(projectId, scanId,
                                    dependencyId, relatedDependencyId));
        }
        return null;
    }

    @Override
    public VulnerabilitiesDTO findAllVulnerabilities(String projectId,
                                                     String scanId, String dependencyId) {

        if ((projectId != null) && (scanId != null) && (dependencyId != null)) {
            return DTOTransformerUtil
                    .transformVulnerabilitySetToVulnerabilitiesDTO(projectRepository
                            .findAllDependencyVulnerabilities(projectId,
                                    scanId, dependencyId));
        }
        return null;
    }

    @Override
    public VulnerabilityDTO findVulnerability(String projectId, String scanId,
                                              String dependencyId, String vulnerabilityId) {

        if ((projectId != null) && (scanId != null) && (dependencyId != null)
                && (vulnerabilityId != null)) {
            return DTOTransformerUtil
                    .transformVulnerabilityToVulnerabilityDTO(projectRepository
                            .findDependencyVulnerability(projectId, scanId,
                                    dependencyId, vulnerabilityId));
        }
        return null;
    }

    @Override
    public IssuesDTO findAllDependencyIssues(String projectId, String scanId,
                                             String dependencyId) {

        if ((projectId != null) && (scanId != null) && (dependencyId != null)) {
            return DTOTransformerUtil
                    .transformIssuesSetToIssuesDTO(projectRepository
                            .findAllDependencyIssues(projectId, scanId,
                                    dependencyId));
        }
        return null;
    }

    @Override
    public IssueDTO findDependencyIssue(String projectId, String scanId,
                                        String dependencyId, String issueId) {

        if ((projectId != null) && (scanId != null) && (dependencyId != null)
                && (issueId != null)) {
            return DTOTransformerUtil
                    .transformIssueToIssueDTO(projectRepository
                            .findDependencyIssue(projectId, scanId,
                                    dependencyId, issueId));
        }
        return null;
    }

    @Override
    public PackagesDTO findAllPackages(String projectId, String scanId) {

        if ((projectId != null) && (scanId != null)) {

            return DTOTransformerUtil
                    .transformPackageSetToPackagesDTO(projectRepository
                            .findAllPackages(projectId, scanId));
        }
        return null;
    }

    @Override
    public PackageDTO findPackage(String projectId, String scanId,
                                  String packageId) {

        if ((projectId != null) && (scanId != null) && (packageId != null)) {
            return DTOTransformerUtil
                    .transformPackageToPackageDTO(projectRepository
                            .findPackage(projectId, scanId, packageId));
        }
        return null;
    }

    @Override
    public ClazzesDTO findAllClazzes(String projectId, String scanId,
                                     String packageId) {

        if ((projectId != null) && (scanId != null) && (packageId != null)) {
            return DTOTransformerUtil
                    .transformClazzSetToClazzesDTO(projectRepository
                            .findAllClazzes(projectId, scanId, packageId));
        }
        return null;
    }

    @Override
    public ClazzDTO findClazz(String projectId, String scanId,
                              String packageId, String clazzId) {

        if ((projectId != null) && (scanId != null) && (packageId != null)
                && (clazzId != null)) {
            return DTOTransformerUtil
                    .transformClazzToClazzDTO(projectRepository.findClazz(
                            projectId, scanId, packageId, clazzId));
        }
        return null;
    }

    @Override
    public MethodsDTO findAllMethods(String projectId, String scanId,
                                     String packageId, String clazzId) {

        if ((projectId != null) && (scanId != null) && (packageId != null)
                && (clazzId != null)) {
            return DTOTransformerUtil
                    .transformMethodSetToMethodsDTO(projectRepository
                            .findAllMethods(projectId, scanId, packageId,
                                    clazzId));
        }
        return null;
    }

    @Override
    public MethodDTO findMethod(String projectId, String scanId,
                                String packageId, String clazzId, String methodId) {

        if ((projectId != null) && (scanId != null) && (packageId != null)
                && (clazzId != null) && (methodId != null)) {
            return DTOTransformerUtil
                    .transformMethodToMethodDTO(projectRepository.findMethod(
                            projectId, scanId, packageId, clazzId, methodId));
        }
        return null;
    }

    @Override
    public ClazzesDTO findAllDependenyClazzes(String projectId, String scanId,
                                              String dependencyId) {

        if ((projectId != null) && (scanId != null) && (dependencyId != null)) {
            return DTOTransformerUtil
                    .transformClazzSetToClazzesDTO(projectRepository
                            .findAllDependencyClazzes(projectId, scanId,
                                    dependencyId));
        }
        return null;
    }

    @Override
    public ClazzDTO findDependenyClazz(String projectId, String scanId,
                                       String dependencyId, String clazzId) {

        if ((projectId != null) && (scanId != null) && (dependencyId != null)
                && (clazzId != null)) {
            return DTOTransformerUtil
                    .transformClazzToClazzDTO(projectRepository
                            .findDependencyClazz(projectId, scanId,
                                    dependencyId, clazzId));
        }
        return null;
    }
}
