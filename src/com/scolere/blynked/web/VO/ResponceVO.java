package com.scolere.blynked.web.VO;

import java.util.List;

public class ResponceVO {

	private String status;
	private int code;
	private List<String> responseList;
	private List<ImeiLocationResponseVO> trackerResponseList;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public List<String> getResponseList() {
		return responseList;
	}
	public void setResponseList(List<String> responseList) {
		this.responseList = responseList;
	}
	public List<ImeiLocationResponseVO> getTrackerResponseList() {
		return trackerResponseList;
	}
	public void setTrackerResponseList(List<ImeiLocationResponseVO> trackerResponseList) {
		this.trackerResponseList = trackerResponseList;
	}
	 
	
}
