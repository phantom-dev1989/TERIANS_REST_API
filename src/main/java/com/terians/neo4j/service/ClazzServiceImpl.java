package com.terians.neo4j.service;

import com.terians.dto.ClazzDTO;
import com.terians.dto.ClazzesDTO;
import com.terians.dto.MethodDTO;
import com.terians.dto.MethodsDTO;
import com.terians.dto.transformer.DTOTransformerUtil;
import com.terians.neo4j.model.Clazz;
import com.terians.neo4j.model.Method;
import com.terians.neo4j.repository.ClazzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by stromero on 1/4/2015.
 */
@Service
@Transactional
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private Neo4jTemplate template;
    @Autowired
    private ClazzRepository clazzRepository;

    @Override
    public ClazzesDTO findAllClazzes() {
        return DTOTransformerUtil.transformClazzSetToClazzesDTO(clazzRepository.findAllClazzes());
    }

    @Override
    public ClazzDTO findClazzById(String clazzId) {
        return DTOTransformerUtil.transformClazzToClazzDTO(clazzRepository.findClazzById(clazzId));
    }

    @Override
    public Integer findClazzCountByScan(String scanId) {
        return clazzRepository.findClazzCountByScan(scanId);
    }

    @Override
    public ClazzesDTO findClazzesByScanOrderedByAfferentCount(String scanId, int limit) {
        return DTOTransformerUtil.transformClazzSetToClazzesDTO(clazzRepository.findClazzesByScanOrderedByAfferentCount(scanId, limit));
    }

    @Override
    public ClazzesDTO findClazzesByScanOrderedByEfferentCount(String scanId, int limit) {
        return DTOTransformerUtil.transformClazzSetToClazzesDTO(clazzRepository.findClazzesByScanOrderedByEfferentCount(scanId, limit));
    }

    @Override
    public MethodsDTO findAllMethods(String clazzId) {

        Clazz clazz = clazzRepository.findClazzById(clazzId);
        template.fetch(clazz.getMethods());

        return DTOTransformerUtil.transformMethodSetToMethodsDTO(clazz.getMethods());
    }

    @Override
    public MethodDTO findMethodById(String clazzId, String methodId) {

        Clazz clazz = clazzRepository.findClazzById(clazzId);
        template.fetch(clazz.getMethods());
        Set<Method> methodSet = clazz.getMethods();
        Method method = null;

        for(Method e : methodSet){

            if(e.getTeriansId().equals(methodId)){

                method = e;
            }
        }
        return DTOTransformerUtil.transformMethodToMethodDTO(method);
    }
}
