package com.terians.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

/**
 * Created by stromero on 3/1/2015.
 */
@JsonRootName("Packages")
public class PackagesDTO {

    private int totalPackages;
    @JsonProperty("PackageList")
    private List<PackageDTO> packageDTOList;

    public PackagesDTO() {
    }

    public PackagesDTO(List<PackageDTO> packageDTOList, int totalPackages) {
        this.packageDTOList = packageDTOList;
        this.totalPackages = totalPackages;
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
