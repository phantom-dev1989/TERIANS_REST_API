package com.terians.neo4j.service;

import com.terians.dto.MethodDTO;
import com.terians.dto.MethodsDTO;


/**
 * Created by stromero on 1/4/2015.
 */
public interface MethodService {

    public Integer findMethodCountByScan(String scanId);

    public MethodsDTO findAllMethods();

    public MethodDTO findMethodById(String methodId);

}

