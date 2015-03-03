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
    private List<MethodDTO> methodDTO;

    public MethodsDTO() {
    }

    public MethodsDTO(List<MethodDTO> methodDTO, int totalMethods) {
        this.methodDTO = methodDTO;
        this.totalMethods = totalMethods;
    }

    public List<MethodDTO> getMethodDTO() {
        return methodDTO;
    }

    public void setMethodDTO(List<MethodDTO> methodDTO) {
        this.methodDTO = methodDTO;
    }

    public int getTotalMethods() {
        return totalMethods;
    }

    public void setTotalMethods(int totalMethods) {
        this.totalMethods = totalMethods;
    }
}
