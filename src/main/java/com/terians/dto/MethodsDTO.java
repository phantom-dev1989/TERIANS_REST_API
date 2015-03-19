package com.terians.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wordnik.swagger.annotations.ApiModel;

import java.util.List;

/**
 * Created by stromero on 3/1/2015.
 */
@ApiModel("Methods")
public class MethodsDTO {

	private int totalMethods;
	@JsonProperty("methodList")
	private List<MethodDTO> methodDTOList;

	public MethodsDTO() {
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
