package com.terians.neo4j.service;

import com.terians.dto.*;
import com.terians.dto.transformer.DTOTransformerUtil;
import com.terians.dto.transformer.IssuesDTOUtil;
import com.terians.neo4j.model.*;
import com.terians.neo4j.repository.ClazzRepository;
import com.terians.neo4j.repository.IssueRepository;
import com.terians.neo4j.repository.PackageRepository;
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
public class ScanServiceImpl implements ScanService {

    @Autowired
    private Neo4jTemplate template;
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
                scanDTO = DTOTransformerUtil.transformScanToScanDTO(scanRepository.findScanById(scanId));
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
            Scan scan = scanRepository.findScanById(scanId);
            template.fetch(scan.getIssues());
            Issue issue = null;
            for (Issue e1 : scan.getIssues()) {
                if (e1.getTeriansId().equals(issueId)) {
                    issue = e1;
                    break;
                }
            }
            return DTOTransformerUtil.transformIssueToIssueDTO(issue);
        }
        return null;
    }

    @Override
    public DependenciesDTO findAllDependencies(String scanId) {

        if ((scanId != null)) {
            Scan scan = scanRepository.findScanById(scanId);
            template.fetch(scan.getDependencies());
            return DTOTransformerUtil.transformDependencySetToDependenciesDTO(scan.getDependencies());
        }
        return null;
    }

    @Override
    public DependencyDTO findDependency(String scanId, String dependencyId) {

        if ((scanId != null) && (dependencyId != null)) {
            Scan scan = scanRepository.findScanById(scanId);
            template.fetch(scan.getDependencies());
            Dependency dependency = null;
            for (Dependency e : scan.getDependencies()) {
                if (e.getTeriansId().equals(dependencyId)) {
                    dependency = e;
                    break;
                }
            }
            return DTOTransformerUtil.transformDependencyToDependencyDTO(dependency);
        }
        return null;
    }

    @Override
    public MethodsDTO findAllDependencyMethods(String scanId, String dependencyId) {

        if ((scanId != null) && (dependencyId != null)) {
            Scan scan = scanRepository.findScanById(scanId);
            template.fetch(scan.getDependencies());
            Dependency dependency = null;
            for (Dependency e : scan.getDependencies()) {
                if (e.getTeriansId().equals(dependencyId)) {
                    dependency = e;
                    template.fetch(dependency.getMethods());
                    break;
                }
            }
            return DTOTransformerUtil.transformMethodSetToMethodsDTO(dependency.getMethods());
        }
        return null;
    }

    @Override
    public MethodDTO findDependencyMethod(String scanId, String dependencyId, String methodId) {

        if ((scanId != null) && (dependencyId != null) && (methodId != null)) {
            Scan scan = scanRepository.findScanById(scanId);
            template.fetch(scan.getDependencies());
            Dependency dependency = null;
            Method method = null;
            for (Dependency e : scan.getDependencies()) {
                if (e.getTeriansId().equals(dependencyId)) {
                    dependency = e;
                    template.fetch(dependency.getMethods());
                    for (Method e1 : dependency.getMethods()) {
                        if (e1.getTeriansId().equals(methodId)) {
                            method = e1;
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
    public DependenciesDTO findAllRelatedDependencies(String scanId, String dependencyId) {

        if ((scanId != null) && (dependencyId != null)) {
            Scan scan = scanRepository.findScanById(scanId);
            template.fetch(scan.getDependencies());
            Dependency dependency = null;
            for (Dependency e : scan.getDependencies()) {
                if (e.getTeriansId().equals(dependencyId)) {
                    dependency = e;
                    template.fetch(dependency.getDependencies());
                    break;
                }
            }
            return DTOTransformerUtil.transformDependencySetToDependenciesDTO(dependency.getDependencies());
        }
        return null;
    }

    @Override
    public DependencyDTO findRelatedDependency(String scanId, String dependencyId, String relatedDependencyId) {

        if ((scanId != null) && (dependencyId != null) && (relatedDependencyId != null)) {
            Scan scan = scanRepository.findScanById(scanId);
            template.fetch(scan.getDependencies());
            Dependency dependency = null;
            Dependency relatedDependency = null;
            for (Dependency e : scan.getDependencies()) {
                if (e.getTeriansId().equals(dependencyId)) {
                    dependency = e;
                    template.fetch(dependency.getDependencies());
                    for (Dependency e2 : dependency.getDependencies()) {
                        relatedDependency = e2;
                        break;
                    }
                    break;
                }
            }
            return DTOTransformerUtil.transformDependencyToDependencyDTO(relatedDependency);
        }
        return null;
    }

    @Override
    public VulnerabilitiesDTO findAllVulnerabilities(String scanId, String dependencyId) {

        if ((scanId != null) && (dependencyId != null)) {
            Scan scan = scanRepository.findScanById(scanId);
            template.fetch(scan.getDependencies());
            Dependency dependency = null;
            for (Dependency e : scan.getDependencies()) {
                if (e.getTeriansId().equals(dependencyId)) {
                    dependency = e;
                    template.fetch(dependency.getVulnerabilities());
                    break;
                }
            }
            return DTOTransformerUtil.transformVulnerabilitySetToVulnerabilitiesDTO(dependency.getVulnerabilities());
        }
        return null;
    }

    @Override
    public VulnerabilityDTO findVulnerability(String scanId, String dependencyId, String vulnerabilityId) {

        if ((scanId != null) && (dependencyId != null) && (vulnerabilityId != null)) {
            Scan scan = scanRepository.findScanById(scanId);
            template.fetch(scan.getDependencies());
            Dependency dependency = null;
            Vulnerability vulnerability = null;
            for (Dependency e : scan.getDependencies()) {
                if (e.getTeriansId().equals(dependencyId)) {
                    dependency = e;
                    template.fetch(dependency.getVulnerabilities());
                    for (Vulnerability e1 : dependency.getVulnerabilities()) {
                        if (e1.getTeriansId().equals(vulnerabilityId)) {
                            vulnerability = e1;
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
    public IssuesDTO findAllDependencyIssues(String scanId, String dependencyId) {

        if ((scanId != null) && (dependencyId != null)) {
            Scan scan = scanRepository.findScanById(scanId);
            template.fetch(scan.getDependencies());
            Dependency dependency = null;
            for (Dependency e : scan.getDependencies()) {
                if (e.getTeriansId().equals(dependencyId)) {
                    dependency = e;
                    template.fetch(dependency.getIssues());
                    break;
                }
            }
            return DTOTransformerUtil.transformIssuesSetToIssuesDTO(dependency.getIssues());
        }
        return null;
    }

    @Override
    public IssueDTO findDependencyIssue(String scanId, String dependencyId, String issueId) {

        if ((scanId != null) && (dependencyId != null) && (issueId != null)) {
            Scan scan = scanRepository.findScanById(scanId);
            template.fetch(scan.getDependencies());
            Dependency dependency = null;
            Issue issue = null;
            for (Dependency e : scan.getDependencies()) {
                if (e.getTeriansId().equals(dependencyId)) {
                    dependency = e;
                    template.fetch(dependency.getIssues());
                    for (Issue e1 : dependency.getIssues()) {
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
    public PackagesDTO findAllPackages(String scanId, String orderedBy, int limit) {

        PackagesDTO packagesDTO = null;

        if ((scanId != null) && (orderedBy == null)) {

            Scan scan = scanRepository.findScanById(scanId);
            template.fetch(scan.getPackages());
            packagesDTO = DTOTransformerUtil.transformPackageSetToPackagesDTO(scan.getPackages());
            return packagesDTO;

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
            Scan scan = scanRepository.findScanById(scanId);
            template.fetch(scan.getPackages());
            com.terians.neo4j.model.Package packageObj = null;
            for (com.terians.neo4j.model.Package e : scan.getPackages()) {
                if (e.getTeriansId().equals(packageId)) {
                    packageObj = e;
                    break;
                }

            }
            return DTOTransformerUtil.transformPackageToPackageDTO(packageObj);
        }
        return null;
    }

    @Override
    public ClazzesDTO findAllClazzes(String scanId, String packageId, String orderedBy, int limit) {

        ClazzesDTO clazzesDTO = null;

        if ((scanId != null) && (packageId != null) && (orderedBy == null)) {

            Scan scan = scanRepository.findScanById(scanId);
            template.fetch(scan.getPackages());
            com.terians.neo4j.model.Package packageObj = null;
            for (com.terians.neo4j.model.Package e : scan.getPackages()) {
                if (e.getTeriansId().equals(packageId)) {
                    packageObj = e;
                    template.fetch(packageObj.getClazzs());
                    clazzesDTO = DTOTransformerUtil.transformClazzSetToClazzesDTO(packageObj.getClazzs());
                    break;
                }
            }
            return clazzesDTO;
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
            Scan scan = scanRepository.findScanById(scanId);
            template.fetch(scan.getPackages());
            com.terians.neo4j.model.Package packageObj = null;
            Clazz clazz = null;
            for (com.terians.neo4j.model.Package e : scan.getPackages()) {
                if (e.getTeriansId().equals(packageId)) {
                    packageObj = e;
                    template.fetch(packageObj.getClazzs());
                    for (Clazz e1 : packageObj.getClazzs()) {
                        if (e1.getTeriansId().equals(clazzId)) {
                            clazz = e1;
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
    public MethodsDTO findAllMethods(String scanId, String packageId, String clazzId) {

        if ((scanId != null) && (packageId != null) && (clazzId != null)) {
            Scan scan = scanRepository.findScanById(scanId);
            template.fetch(scan.getPackages());
            com.terians.neo4j.model.Package packageObj = null;
            Clazz clazz = null;
            for (com.terians.neo4j.model.Package e : scan.getPackages()) {
                if (e.getTeriansId().equals(packageId)) {
                    packageObj = e;
                    template.fetch(packageObj.getClazzs());
                    for (Clazz e1 : packageObj.getClazzs()) {
                        if (e1.getTeriansId().equals(clazzId)) {
                            clazz = e1;
                            template.fetch(clazz.getMethods());
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
    public MethodDTO findMethod(String scanId, String packageId, String clazzId, String methodId) {

        if ((scanId != null) && (packageId != null) && (clazzId != null) && (methodId == null)) {
            Scan scan = scanRepository.findScanById(scanId);
            template.fetch(scan.getPackages());
            com.terians.neo4j.model.Package packageObj = null;
            Clazz clazz = null;
            Method method = null;
            for (com.terians.neo4j.model.Package e : scan.getPackages()) {
                if (e.getTeriansId().equals(packageId)) {
                    packageObj = e;
                    template.fetch(packageObj.getClazzs());
                    for (Clazz e1 : packageObj.getClazzs()) {
                        if (e1.getTeriansId().equals(clazzId)) {
                            clazz = e1;
                            template.fetch(clazz.getMethods());
                            for (Method e2 : clazz.getMethods()) {
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
}
