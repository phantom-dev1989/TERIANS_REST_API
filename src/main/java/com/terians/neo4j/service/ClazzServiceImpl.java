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
    public ClazzDTO findClazz(String clazzId) {

        if (clazzId != null) {
            return DTOTransformerUtil.transformClazzToClazzDTO(clazzRepository.findClazzById(clazzId));
        }
        return null;
    }

    @Override
    public MethodsDTO findAllMethods(String clazzId) {

        if (clazzId != null) {
            Clazz clazz = clazzRepository.findClazzById(clazzId);
            template.fetch(clazz.getMethods());
            return DTOTransformerUtil.transformMethodSetToMethodsDTO(clazz.getMethods());
        }
        return null;
    }

    @Override
    public MethodDTO findMethod(String clazzId, String methodId) {

        if ((clazzId != null) && (methodId != null)) {

            Clazz clazz = clazzRepository.findClazzById(clazzId);
            template.fetch(clazz.getMethods());
            Method method = null;

            for (Method e : clazz.getMethods()) {
                if (e.getTeriansId().equals(methodId)) {
                    method = e;
                    break;
                }
            }
            return DTOTransformerUtil.transformMethodToMethodDTO(method);
        }
        return null;
    }
}
