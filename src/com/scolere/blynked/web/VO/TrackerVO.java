package com.scolere.blynked.web.VO;

public class TrackerVO {

	String imeiNo;
	double startLocationLat;
	double startLocationLong;
	double endLocationLat;
	double endLocationLong;
	double currentLocationLat;
	double currentLocationLong;
	String userName;
	String profileImage;
	String contactNo;
	
        
        
	public String getImeiNo() {
		return imeiNo;
	}
	public void setImeiNo(String imeiNo) {
		this.imeiNo = imeiNo;
	}
	public double getStartLocationLat() {
		return startLocationLat;
	}
	public void setStartLocationLat(double startLocationLat) {
		this.startLocationLat = startLocationLat;
	}
	public double getStartLocationLong() {
		return startLocationLong;
	}
	public void setStartLocationLong(double startLocationLong) {
		this.startLocationLong = startLocationLong;
	}
	public double getEndLocationLat() {
		return endLocationLat;
	}
	public void setEndLocationLat(double endLocationLat) {
		this.endLocationLat = endLocationLat;
	}
	public double getEndLocationLong() {
		return endLocationLong;
	}
	public void setEndLocationLong(double endLocationLong) {
		this.endLocationLong = endLocationLong;
	}
	public double getCurrentLocationLat() {
		return currentLocationLat;
	}
	public void setCurrentLocationLat(double currentLocationLat) {
		this.currentLocationLat = currentLocationLat;
	}
	public double getCurrentLocationLong() {
		return currentLocationLong;
	}
	public void setCurrentLocationLong(double currentLocationLong) {
		this.currentLocationLong = currentLocationLong;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

        
    @Override
    public String toString() {
        return "TrackerVO{" + "imeiNo=" + imeiNo + ", startLocationLat=" + startLocationLat + ", startLocationLong=" + startLocationLong + ", endLocationLat=" + endLocationLat + ", endLocationLong=" + endLocationLong + ", currentLocationLat=" + currentLocationLat + ", currentLocationLong=" + currentLocationLong + ", userName=" + userName + ", profileImage=" + profileImage + ", contactNo=" + contactNo + '}';
    }
	
	
}
