package com.terians.neo4j.service;

import com.terians.dto.ClazzDTO;
import com.terians.dto.ClazzesDTO;
import com.terians.dto.MethodDTO;
import com.terians.dto.MethodsDTO;

/**
 * Created by stromero on 1/4/2015.
 */
public interface ClazzService {

    public ClazzesDTO findAllClazzes();

    public ClazzDTO findClazzById(String clazzId);

    public Integer findClazzCountByScan(String scanId);

    public ClazzesDTO findClazzesByScanOrderedByAfferentCount(String scanId, int limit);

    public ClazzesDTO findClazzesByScanOrderedByEfferentCount(String scanId, int limit);

    public MethodsDTO findAllMethods(String methodId);

    public MethodDTO findMethodById(String clazzId, String methodId);

}

