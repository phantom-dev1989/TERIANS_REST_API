package com.terians.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

/**
 * Created by stromero on 3/1/2015.
 */
@JsonRootName("Methods")
public class MethodsDTO {

    private int totalMethods;
    @JsonProperty("MethodList")
    private List<MethodDTO> methodDTOList;

    public MethodsDTO() {
    }

    public MethodsDTO(List<MethodDTO> methodDTOList, int totalMethods) {
        this.methodDTOList = methodDTOList;
        this.totalMethods = totalMethods;
    }

    public List<MethodDTO> getMethodDTOList() {
        return methodDTOList;
    }

    public void setMethodDTOList(List<MethodDTO> methodDTOList) {
        this.methodDTOList = methodDTOList;
    }

    public int getTotalMethods() {
        return totalMethods;
    }

    public void setTotalMethods(int totalMethods) {
        this.totalMethods = totalMethods;
    }
}
