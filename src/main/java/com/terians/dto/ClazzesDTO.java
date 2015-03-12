package com.terians.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

/**
 * Created by stromero on 3/1/2015.
 */
public class ClazzesDTO {

    private int totalClazzes;
    @JsonProperty("classList")
    private List<ClazzDTO> clazzDTOList;

    public ClazzesDTO() {
    }

    public ClazzesDTO(int totalClazzes, List<ClazzDTO> clazzDTOList) {
        this.totalClazzes = totalClazzes;
        this.clazzDTOList = clazzDTOList;
    }

    public List<ClazzDTO> getClazzDTOList() {
        return clazzDTOList;
    }

    public void setClazzDTOList(List<ClazzDTO> clazzDTOList) {
        this.clazzDTOList = clazzDTOList;
    }

    public int getTotalClazzes() {
        return totalClazzes;
    }

    public void setTotalClazzes(int totalClazzes) {
        this.totalClazzes = totalClazzes;
    }
}
