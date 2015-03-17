package com.terians.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wordnik.swagger.annotations.ApiModel;

import java.util.List;

/**
 * Created by stromero on 3/1/2015.
 */
@ApiModel("Packages")
public class PackagesDTO {

    private int totalPackages;
    @JsonProperty("packageList")
    private List<PackageDTO> packageDTOList;

    public PackagesDTO() {
    }

    public List<PackageDTO> getPackageDTOList() {
        return packageDTOList;
    }

    public void setPackageDTOList(List<PackageDTO> packageDTOList) {
        this.packageDTOList = packageDTOList;
    }

    public int getTotalPackages() {
        return totalPackages;
    }

    public void setTotalPackages(int totalPackages) {
        this.totalPackages = totalPackages;
    }
}
