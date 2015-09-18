
package com.scolere.blynked.persistance.dao.iface;


/**
 *
 * @author admin
 */
public interface UploadDetailDao {

	public boolean checkNum(String mobileNum)throws Exception;
	
	public boolean saveDetail(String username, String mobileNum, String email, String os,
			String softVersion, String deviceName,String filePath,String imeiNo)throws Exception;
	 
	public boolean updateDetail(String username, String filePath, String mobileNum)throws Exception;
		
	public String saveOnlyDetail(String username, String mobileNum,
			String email, String uploadImage, String os, String softVersion,
			String deviceName)throws Exception;

	 

}
