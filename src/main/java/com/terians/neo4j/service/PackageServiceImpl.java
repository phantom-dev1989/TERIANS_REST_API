package com.terians.neo4j.service;

import com.terians.dto.*;
import com.terians.dto.transformer.DTOTransformerUtil;
import com.terians.neo4j.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by stromero on 1/4/2015.
 */
@Service
@Transactional
public class PackageServiceImpl implements PackageService {

    @Autowired
    private Neo4jTemplate template;
    @Autowired
    private PackageRepository packageRepository;

    @Override
    public Integer findPackageCountByScan(String teriansId) {
        return packageRepository.findPackageCountByScan(teriansId);
    }

    @Override
    public PackagesDTO findPackagesByScanOrderedByAfferentCount(String teriansId, int limit) {
        return DTOTransformerUtil.transformPackageSetToPackagesDTO(packageRepository.findPackagesByScanOrderedByAfferentCount(teriansId, limit));
    }

    @Override
    public PackagesDTO findPackagesByScanOrderedByEfferentCount(String teriansId, int limit) {
        return DTOTransformerUtil.transformPackageSetToPackagesDTO(packageRepository.findPackagesByScanOrderedByEfferentCount(teriansId, limit));
    }

    @Override
    public PackagesDTO findAllPackages() {
        return null;
    }

    @Override
    public PackageDTO findPackage(String packageId) {
        return null;
    }

    @Override
    public ClazzesDTO findAllClazzes(String packageId) {
        return null;
    }

    @Override
    public ClazzDTO findClazz(String packageId, String clazzId) {
        return null;
    }

    @Override
    public MethodsDTO findAllMethods(String packageId, String clazzId) {
        return null;
    }

    @Override
    public MethodDTO findMethod(String packageId, String clazzId, String methodId) {
        return null;
    }

}
