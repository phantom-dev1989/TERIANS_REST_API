package com.terians.neo4j.service;

import com.terians.dto.ClazzesDTO;
import com.terians.dto.transformer.DTOTransformerUtil;
import com.terians.neo4j.repository.ClazzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by stromero on 1/4/2015.
 */
@Service
@Transactional
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzRepository repository;

    @Override
    public Integer findClazzCountByScan(String teriansId) {
        return repository.findClazzCountByScan(teriansId);
    }

    @Override
    public ClazzesDTO findClazzesByScanOrderedByAfferentCount(String teriansId, int limit) {
        return DTOTransformerUtil.transformClazzSetToClazzesDTO(repository.findClazzesByScanOrderedByAfferentCount(teriansId, limit));
    }

    @Override
    public ClazzesDTO findClazzesByScanOrderedByEfferentCount(String teriansId, int limit) {
        return DTOTransformerUtil.transformClazzSetToClazzesDTO(repository.findClazzesByScanOrderedByEfferentCount(teriansId, limit));
    }


}
