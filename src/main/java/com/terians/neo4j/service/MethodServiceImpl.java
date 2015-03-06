package com.terians.neo4j.service;

import com.terians.dto.MethodDTO;
import com.terians.dto.MethodsDTO;
import com.terians.dto.transformer.DTOTransformerUtil;
import com.terians.neo4j.repository.MethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by stromero on 1/4/2015.
 */
@Service
@Transactional
public class MethodServiceImpl implements MethodService {

    @Autowired
    private MethodRepository methodRepository;

    @Override
    public Integer findMethodCountByScan(String scanId) {
        return methodRepository.findMethodCountByScan(scanId);
    }

    @Override
    public MethodsDTO findAllMethods() {
        return DTOTransformerUtil.transformMethodSetToMethodsDTO(methodRepository.findAllMethods());
    }

    @Override
    public MethodDTO findMethodById(String methodId) {
        return DTOTransformerUtil.transformMethodToMethodDTO(methodRepository.findMethodById(methodId));
    }
}
