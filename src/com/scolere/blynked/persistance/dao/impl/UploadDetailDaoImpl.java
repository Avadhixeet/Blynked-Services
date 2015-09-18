
package com.scolere.blynked.persistance.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.scolere.blynked.persistance.dao.iface.UploadDetailDao;
import com.scolere.blynked.persistance.factory.LmsDaoAbstract;


public class UploadDetailDaoImpl extends LmsDaoAbstract implements UploadDetailDao {

	
	 Connection conn = null;
	 Statement stmt = null;
	 ResultSet rs = null;
	 
	 //Check if the no exist??
	 @Override
		public boolean checkNum(String mobileNum) throws Exception {
			System.out.println("Check User Exist..?");
			boolean mobNum= false; 
			String sql="";
			try{
				conn = getConnection();
				stmt = conn.prepareStatement(sql);
				
				sql="SELECT phone FROM blynk_users where phone = '"+mobileNum+"'";
				
	            rs = stmt.executeQuery(sql);
	            if(rs.next())
	            {
	            	mobNum = true;
	            }
	            else {
	            	mobNum = false;
	            }
			  } catch (SQLException se) {
		        	 System.out.println("SQLException"+se);
		            se.printStackTrace();
		        } catch (Exception e) {
		        	 System.out.println("Exception"+e);
		            e.printStackTrace();
		        } finally {
		            closeResources(conn, stmt, rs);
		            System.out.println("out from database");
		        }
			return mobNum;			
			
			
		}
	 
	 
	 //save the details of the user.......
	@Override
	public boolean saveDetail(String username, String mobileNum, String email,
			  String os,String softVersion, String deviceName,String filePath,String imeiNo) throws Exception {
		
		
		Date date=new Date();
	System.out.println("Successfully come into UploadDetailDaoImpl");

	String sql="";
		 try {
			   conn = getConnection();
			   stmt = conn.prepareStatement(sql);

				   sql = "Insert into blynk_users(user_name, phone, email, file_path, last_id_update_detail, device_name, os, software_version, imei_no) " +
				   		"values('"+username+"', '"+mobileNum+"', '"+email+"', '"+filePath+"','"+date+"','"+deviceName+"' ,'"+os+"' ,'"+softVersion+"' ,'"+imeiNo+"')";  
           System.out.println("Query run successfully  "+sql);

            stmt.executeUpdate(sql);
	            
	        } catch (SQLException se) {
	        	 System.out.println("SQLException"+se);
	            se.printStackTrace();
	        } catch (Exception e) {
	        	 System.out.println("Exception"+e);
	            e.printStackTrace();
	        } finally {
	            closeResources(conn, stmt, null);
	            System.out.println("out from database");
	        }
		return true;
	}
	
	
	@Override
	public String saveOnlyDetail(String username, String mobileNum,
			String email, String uploadImage, String os, String softVersion,
			String deviceName) {
		Date date=new Date();
		String imageFileName=null;
		System.out.println("Successfully come into UploadDetailDaoImpl");
		int id=0;
		String sql="";
			 try {
				   conn = getConnection();
				   stmt = conn.createStatement();
				   
		            sql = "Insert into blynk_users(user_name, phone, email, file_path, last_id_update_detail , device_name, os, software_version ) " +
		            		"values('"+username+"', '"+mobileNum+"', '"+email+"', '"+uploadImage+"','"+date+"','"+deviceName+"' ,'"+os+"' ,'"+softVersion+"')";
		            stmt.executeUpdate(sql);
		            System.out.println("Save data Successfully");
		            
		            
		        } catch (SQLException se) {
		        	 System.out.println("SQLException "+se);
		            se.printStackTrace();
		        } catch (Exception e) {
		        	 System.out.println("Exception "+e);
		            e.printStackTrace();
		        } finally {
		            closeResources(conn, stmt, null);
		        }
		        return imageFileName;
	}

	//update the user information.......
	@Override
	public boolean updateDetail(String username, String filePath, String mobileNum)
			throws Exception {

		Date date=new Date();
	System.out.println("Updated information about the user");

	String sql="";
		 try {
			   conn = getConnection();
			   stmt = conn.prepareStatement(sql);

				   sql = "UPDATE blynk_users SET user_name='"+username+"', file_path='"+filePath+"', last_id_update_detail='"+date+"' WHERE phone = '"+mobileNum+"'";
 
           System.out.println("Query run successfully  "+sql);

            stmt.executeUpdate(sql);
	            
	        } catch (SQLException se) {
	        	 System.out.println("SQLException"+se);
	            se.printStackTrace();
	        } catch (Exception e) {
	        	 System.out.println("Exception"+e);
	            e.printStackTrace();
	        } finally {
	            closeResources(conn, stmt, null);
	            System.out.println("out from database");
	        }
		return true;
	}


	
	 
}//end of class
