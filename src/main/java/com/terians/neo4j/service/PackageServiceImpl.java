package com.terians.neo4j.service;

import com.terians.dto.*;
import com.terians.dto.transformer.DTOTransformerUtil;
import com.terians.neo4j.model.Clazz;
import com.terians.neo4j.model.Method;
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
    public PackagesDTO findAllPackages() {
        return DTOTransformerUtil.transformPackageSetToPackagesDTO(packageRepository.findAllPackages());
    }

    @Override
    public PackageDTO findPackage(String packageId) {

        if (packageId != null) {
            return DTOTransformerUtil.transformPackageToPackageDTO(packageRepository.findPackageById(packageId));
        }
        return null;
    }

    @Override
    public ClazzesDTO findAllClazzes(String packageId) {

        if (packageId != null) {

            com.terians.neo4j.model.Package packageObj = packageRepository.findPackageById(packageId);
            template.fetch(packageObj.getClazzs());
            return DTOTransformerUtil.transformClazzSetToClazzesDTO(packageObj.getClazzs());
        }
        return null;
    }

    @Override
    public ClazzDTO findClazz(String packageId, String clazzId) {

        if ((packageId != null) && (clazzId != null)) {
            com.terians.neo4j.model.Package packageObj = packageRepository.findPackageById(packageId);
            template.fetch(packageObj.getClazzs());
            Clazz clazz = null;
            for (Clazz e : packageObj.getClazzs()) {
                if (e.getTeriansId().equals(clazzId)) {
                    clazz = e;
                    break;
                }
            }
            return DTOTransformerUtil.transformClazzToClazzDTO(clazz);
        }
        return null;
    }

    @Override
    public MethodsDTO findAllMethods(String packageId, String clazzId) {

        if ((packageId != null) && (clazzId != null)) {
            com.terians.neo4j.model.Package packageObj = packageRepository.findPackageById(packageId);
            template.fetch(packageObj.getClazzs());
            Clazz clazz = null;
            for (Clazz e : packageObj.getClazzs()) {
                if (e.getTeriansId().equals(clazzId)) {
                    clazz = e;
                    template.fetch(clazz.getMethods());
                    break;
                }
            }
            return DTOTransformerUtil.transformMethodSetToMethodsDTO(clazz.getMethods());
        }
        return null;
    }

    @Override
    public MethodDTO findMethod(String packageId, String clazzId, String methodId) {

        if ((packageId != null) && (clazzId != null) && (methodId != null)) {
            com.terians.neo4j.model.Package packageObj = packageRepository.findPackageById(packageId);
            template.fetch(packageObj.getClazzs());
            Clazz clazz = null;
            Method method = null;
            for (Clazz e : packageObj.getClazzs()) {
                if (e.getTeriansId().equals(clazzId)) {
                    clazz = e;
                    template.fetch(clazz.getMethods());
                    for (Method e1 : clazz.getMethods()) {
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
}
