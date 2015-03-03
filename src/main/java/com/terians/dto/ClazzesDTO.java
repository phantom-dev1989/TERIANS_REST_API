package com.terians.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

/**
 * Created by stromero on 3/1/2015.
 */
@JsonRootName("Clazzes")
public class ClazzesDTO {

    private int totalClazzes;
    @JsonProperty("ClazzList")
    private List<ClazzDTO> clazzDTOs;

    public ClazzesDTO() {
    }

    public ClazzesDTO(int totalClazzes, List<ClazzDTO> clazzDTOs) {
        this.totalClazzes = totalClazzes;
        this.clazzDTOs = clazzDTOs;
    }

    public List<ClazzDTO> getClazzDTOs() {
        return clazzDTOs;
    }

    public void setClazzDTOs(List<ClazzDTO> clazzDTOs) {
        this.clazzDTOs = clazzDTOs;
    }

    public int getTotalClazzes() {
        return totalClazzes;
    }

    public void setTotalClazzes(int totalClazzes) {
        this.totalClazzes = totalClazzes;
    }
}
