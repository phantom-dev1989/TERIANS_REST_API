package com.terians.neo4j.service;

import com.terians.dto.ClazzesDTO;
/**
 * Created by stromero on 1/4/2015.
 */
public interface ClazzService {

    public Integer findClazzCountByScan(String teriansId);

    public ClazzesDTO findClazzesByScanOrderedByAfferentCount(String teriansId, int limit);

    public ClazzesDTO findClazzesByScanOrderedByEfferentCount(String teriansId, int limit);

}

