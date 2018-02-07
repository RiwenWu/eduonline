package com.wrw.eduonline.entity.dto;

import com.wrw.eduonline.entity.Sort;

public class SortDTO extends Sort{

	private Long FirstMenuNameId;
	
	private String firstMenuName;

	private Long secondMenuNameId;
	
	private String secondMenuName;

	public Long getFirstMenuNameId() {
		return FirstMenuNameId;
	}

	public void setFirstMenuNameId(Long firstMenuNameId) {
		FirstMenuNameId = firstMenuNameId;
	}

	public Long getSecondMenuNameId() {
		return secondMenuNameId;
	}

	public void setSecondMenuNameId(Long secondMenuNameId) {
		this.secondMenuNameId = secondMenuNameId;
	}

	public String getFirstMenuName() {
		return firstMenuName;
	}

	public void setFirstMenuName(String firstMenuName) {
		this.firstMenuName = firstMenuName;
	}

	public String getSecondMenuName() {
		return secondMenuName;
	}

	public void setSecondMenuName(String secondMenuName) {
		this.secondMenuName = secondMenuName;
	}
	
	
	
}
