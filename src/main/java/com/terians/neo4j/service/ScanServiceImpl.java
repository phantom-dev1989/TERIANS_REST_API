package com.terians.neo4j.service;

import com.terians.dto.*;
import com.terians.dto.transformer.DTOTransformerUtil;
import com.terians.dto.transformer.IssuesDTOUtil;
import com.terians.neo4j.repository.ClazzRepository;
import com.terians.neo4j.repository.IssueRepository;
import com.terians.neo4j.repository.PackageRepository;
import com.terians.neo4j.repository.ScanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by stromero on 1/4/2015.
 */
@Service
@Transactional
public class ScanServiceImpl implements ScanService {

    @Autowired
    private ScanRepository scanRepository;
    @Autowired
    private IssueRepository issueRepository;
    @Autowired
    private PackageRepository packageRepository;
    @Autowired
    private ClazzRepository clazzRepository;

    @Override
    public ScansDTO findAllScans() {

        return DTOTransformerUtil.transformScanSetToScansDTO(scanRepository.findAllScans());
    }

    @Override
    public ScanDTO findScan(String scanId, String scanned) {

        ScanDTO scanDTO = null;
        if (scanId != null) {

            if (scanned == null) {
                scanDTO = DTOTransformerUtil.transformScanToScanDTO(scanRepository.findScan(scanId));
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
    public IssuesDTO findAllIssues(String scanId, String category, String orderedBy, int limit) {

        if (scanId != null) {
            return IssuesDTOUtil.findAllIssues(issueRepository, scanId, category, orderedBy, limit);
        }
        return null;
    }

    @Override
    public IssueDTO findIssue(String scanId, String issueId) {

        if ((scanId != null) && (issueId != null)) {
            return DTOTransformerUtil.transformIssueToIssueDTO(scanRepository.findIssue(scanId, issueId));
        }
        return null;
    }

    @Override
    public DependenciesDTO findAllDependencies(String scanId) {

        if ((scanId != null)) {
            return DTOTransformerUtil.transformDependencySetToDependenciesDTO(scanRepository
                    .findAllDependencies(scanId));
        }
        return null;
    }

    @Override
    public DependencyDTO findDependency(String scanId, String dependencyId) {

        if ((scanId != null) && (dependencyId != null)) {
            return DTOTransformerUtil.transformDependencyToDependencyDTO(scanRepository
                    .findDependency(scanId, dependencyId));
        }
        return null;
    }

    @Override
    public MethodsDTO findAllDependencyMethods(String scanId, String dependencyId) {

        if ((scanId != null) && (dependencyId != null)) {
            return DTOTransformerUtil.transformMethodSetToMethodsDTO(scanRepository
                    .findAllDependencyMethods(scanId, dependencyId));
        }
        return null;
    }

    @Override
    public MethodDTO findDependencyMethod(String scanId, String dependencyId, String methodId) {

        if ((scanId != null) && (dependencyId != null) && (methodId != null)) {
            return DTOTransformerUtil.transformMethodToMethodDTO(scanRepository
                    .findDependencyMethod(scanId, dependencyId, methodId));
        }
        return null;
    }

    @Override
    public DependenciesDTO findAllRelatedDependencies(String scanId, String dependencyId) {

        if ((scanId != null) && (dependencyId != null)) {
            return DTOTransformerUtil.transformDependencySetToDependenciesDTO(scanRepository
                    .findAllRelatedDependencies(scanId, dependencyId));
        }
        return null;
    }

    @Override
    public DependencyDTO findRelatedDependency(String scanId, String dependencyId, String relatedDependencyId) {

        if ((scanId != null) && (dependencyId != null) && (relatedDependencyId != null)) {
            return DTOTransformerUtil.transformDependencyToDependencyDTO(scanRepository
                    .findRelatedDependency(scanId, dependencyId, relatedDependencyId));
        }
        return null;
    }

    @Override
    public VulnerabilitiesDTO findAllVulnerabilities(String scanId, String dependencyId) {

        if ((scanId != null) && (dependencyId != null)) {
            return DTOTransformerUtil.transformVulnerabilitySetToVulnerabilitiesDTO(scanRepository
                    .findAllDependencyVulnerabilities(scanId, dependencyId));
        }
        return null;
    }

    @Override
    public VulnerabilityDTO findVulnerability(String scanId, String dependencyId, String vulnerabilityId) {

        if ((scanId != null) && (dependencyId != null) && (vulnerabilityId != null)) {
            return DTOTransformerUtil.transformVulnerabilityToVulnerabilityDTO(scanRepository
                    .findDependencyVulnerability(scanId, dependencyId, vulnerabilityId));
        }
        return null;
    }

    @Override
    public IssuesDTO findAllDependencyIssues(String scanId, String dependencyId) {

        if ((scanId != null) && (dependencyId != null)) {
            return DTOTransformerUtil.transformIssuesSetToIssuesDTO(scanRepository
                    .findAllDependencyIssues(scanId, dependencyId));
        }
        return null;
    }

    @Override
    public IssueDTO findDependencyIssue(String scanId, String dependencyId, String issueId) {

        if ((scanId != null) && (dependencyId != null) && (issueId != null)) {
            return DTOTransformerUtil.transformIssueToIssueDTO(scanRepository
                    .findDependencyIssue(scanId, dependencyId, issueId));
        }
        return null;
    }

    @Override
    public PackagesDTO findAllPackages(String scanId, String orderedBy, int limit) {

        PackagesDTO packagesDTO = null;

        if ((scanId != null) && (orderedBy == null)) {

            return DTOTransformerUtil.transformPackageSetToPackagesDTO(scanRepository.findAllPackages(scanId));

        } else if (scanId != null) {

            String[] orderedByArray = orderedBy.split(",");
            String orderedByValue = orderedByArray[0];
            String descOrAsc = orderedByArray[1];

            if ((orderedByValue != null) && (orderedBy.equals("afferent"))) {

                if ((descOrAsc != null) && (descOrAsc.equals("desc"))) {
                    packagesDTO = DTOTransformerUtil.transformPackageSetToPackagesDTO(packageRepository
                            .findPackagesByScanOrderedByAfferentCount(scanId, limit));
                    return packagesDTO;
                }

            } else if ((orderedByValue != null) && (orderedBy.equals("efferent"))) {

                if ((descOrAsc != null) && (descOrAsc.equals("desc"))) {
                    packagesDTO = DTOTransformerUtil.transformPackageSetToPackagesDTO(packageRepository
                            .findPackagesByScanOrderedByEfferentCount(scanId, limit));
                    return packagesDTO;
                }

            }
        }
        return null;
    }

    @Override
    public PackageDTO findPackage(String scanId, String packageId) {

        if ((scanId != null) && (packageId != null)) {
            return DTOTransformerUtil.transformPackageToPackageDTO(scanRepository.findPackage(scanId, packageId));
        }
        return null;
    }

    @Override
    public ClazzesDTO findAllClazzes(String scanId, String packageId, String orderedBy, int limit) {

        ClazzesDTO clazzesDTO = null;

        if ((scanId != null) && (packageId != null) && (orderedBy == null)) {

            return DTOTransformerUtil.transformClazzSetToClazzesDTO(scanRepository.findAllClazzes(scanId, packageId));

        } else if ((scanId != null) && (packageId != null)) {

            String[] orderedByArray = orderedBy.split(",");
            String orderedByValue = orderedByArray[0];
            String descOrAsc = orderedByArray[1];

            if ((orderedByValue != null) && (orderedBy.equals("afferent"))) {

                if ((descOrAsc != null) && (descOrAsc.equals("desc"))) {
                    clazzesDTO = DTOTransformerUtil.transformClazzSetToClazzesDTO(clazzRepository
                            .findClazzesByScanOrderedByAfferentCount(scanId, limit));
                    return clazzesDTO;
                }

            } else if ((orderedByValue != null) && (orderedBy.equals("efferent"))) {

                if ((descOrAsc != null) && (descOrAsc.equals("desc"))) {
                    clazzesDTO = DTOTransformerUtil.transformClazzSetToClazzesDTO(clazzRepository
                            .findClazzesByScanOrderedByEfferentCount(scanId, limit));
                    return clazzesDTO;
                }
            }
        }
        return null;
    }

    @Override
    public ClazzDTO findClazz(String scanId, String packageId, String clazzId) {

        if ((scanId != null) && (packageId != null) && (clazzId != null)) {
            return DTOTransformerUtil.transformClazzToClazzDTO(scanRepository.findClazz(scanId, packageId, clazzId));
        }
        return null;
    }

    @Override
    public MethodsDTO findAllMethods(String scanId, String packageId, String clazzId) {

        if ((scanId != null) && (packageId != null) && (clazzId != null)) {
            return DTOTransformerUtil.transformMethodSetToMethodsDTO(scanRepository
                    .findAllMethods(scanId, packageId, clazzId));
        }
        return null;
    }

    @Override
    public MethodDTO findMethod(String scanId, String packageId, String clazzId, String methodId) {

        if ((scanId != null) && (packageId != null) && (clazzId != null) && (methodId != null)) {
            return DTOTransformerUtil.transformMethodToMethodDTO(scanRepository
                    .findMethod(scanId, packageId, clazzId, methodId));
        }
        return null;
    }

    @Override
    public ClazzesDTO findAllDependenyClazzes(String scanId, String dependencyId) {

        if ((scanId != null) && (dependencyId != null)) {
            return DTOTransformerUtil.transformClazzSetToClazzesDTO(scanRepository
                    .findAllDependencyClazzes(scanId, dependencyId));
        }
        return null;
    }

    @Override
    public ClazzDTO findDependenyClazz(String scanId, String dependencyId, String clazzId) {

        if ((scanId != null) && (dependencyId != null) && (clazzId != null)) {
            return DTOTransformerUtil.transformClazzToClazzDTO(scanRepository
                    .findDependencyClazz(scanId, dependencyId, clazzId));
        }
        return null;
    }
}
