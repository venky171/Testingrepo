package com.mohap.apiTestingPojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProcessBase {

	  

	public int ResultType;
	private int ResultCode;
	private String ResultDesc;
	private List<ProcessDetail> Result;
	 
	
	 
	public List<ProcessDetail> getResult() {
		return Result;
	}
	public void setResult(List<ProcessDetail> result) {
		Result = result;
	}
	public int getResultType() {
		return ResultType;
	}
	public void setResultType(int resultType) {
		ResultType = resultType;
	}
	public int getResultCode() {
		return ResultCode;
	}
	public void setResultCode(int resultCode) {
		ResultCode = resultCode;
	}
	public String getResultDesc() {
		return ResultDesc;
	}
	public void setResultDesc(String resultDesc) {
		ResultDesc = resultDesc;
	}
	
	
	   
	
	
	
	  
	
	
	
	
}
