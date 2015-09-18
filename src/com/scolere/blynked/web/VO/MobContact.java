package com.scolere.blynked.web.VO;

import java.util.List;

public class MobContact {

	String Name;
	String Number;
	List<MobContact> mobNumber;
	
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getNumber() {
		return Number;
	}
	public void setNumber(String number) {
		Number = number;
	}
	public List<MobContact> getMobNumber() {
		return mobNumber;
	}
	public void setMobNumber(List<MobContact> mobNumber) {
		this.mobNumber = mobNumber;
	}
	
	

}
