package com.scolere.blynked.persistance.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.scolere.blynked.persistance.dao.iface.getValidNumberDao;
import com.scolere.blynked.persistance.factory.LmsDaoAbstract;


public class getValidNumberDaoImpl extends LmsDaoAbstract implements getValidNumberDao{

	
	Connection conn=null;
	Statement stmt=null;
	ResultSet res=null;
	
	@Override
	public ArrayList<String> getNumbers(ArrayList<String> getNumberList) {
		
		ArrayList<String> validnum = new ArrayList<String>();

		String sql="";
		 try {
			 conn = getConnection();
			   stmt = conn.createStatement();

			   if(getNumberList!=null){
				   
				   for(int i=0; i<getNumberList.size(); i++){
				   sql="Select phone from blynk_users b where b.phone='"+getNumberList.get(i)+"'";
				   System.out.println(sql);
				   res = stmt.executeQuery(sql);
				   	while(res.next()){
				   		String num = res.getString("phone");
				   		validnum.add(num);		 
				   	}
				   }
			   }
			   
	        } catch (SQLException se) {
	            se.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            closeResources(conn, stmt, res);
	        }
	        return validnum;
	}

	@Override
	public ArrayList<String> getNumbers(String numStr) {
		
		ArrayList<String> validnum = new ArrayList<String>();

		String sql="";
		 try {
			 conn = getConnection();
			   stmt = conn.createStatement();

			   if(numStr!=null){		
				   //Query to check the number string
				   sql="Select phone from blynk_users b where b.phone in ("+numStr+")";
				   System.out.println(sql);
				   res = stmt.executeQuery(sql);
				   	while(res.next()){
				   		String num = res.getString("phone");
				   		validnum.add(num);		 
				   }
			   }
			   
	        } catch (SQLException se) {
	            se.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            closeResources(conn, stmt, res);
	        }
	        return validnum;
	}
	
	
	/*@Override
	public HashSet getNumbers(ArrayList getNumberList) {
		
		HashSet validnum = new HashSet();
		String sql="";
		 try {
			 conn = getConnection();
			   stmt = conn.createStatement();
			   if(getNumberList!=null){
				   Iterator i = getNumberList.iterator();
				   while(i.hasNext()){
					   sql="Select phone from blynk_users b where b.phone="+i.next()+" ";
					   res = stmt.executeQuery(sql);
					   	if(res.next()){
					   		String num = res.getString("phone");
					   		validnum.add(num);
					   	}
				   }
			   }
			   
	        } catch (SQLException se) {
	            se.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            closeResources(conn, stmt, res);
	        }
	        return validnum;
	}*/


	 
}