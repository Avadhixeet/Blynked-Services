package com.scolere.blynked.persistance.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.scolere.blynked.persistance.dao.iface.GetLocationByImeiNoDao;
import com.scolere.blynked.persistance.factory.LmsDaoAbstract;
import com.scolere.blynked.web.VO.ImeiLocationResponseVO;

public class GetLocationByImeiNoDaoImpl extends LmsDaoAbstract implements GetLocationByImeiNoDao{
	
	Connection conn=null;
	Statement stmt=null;
	ResultSet res=null;
	
	@Override
	public ArrayList<ImeiLocationResponseVO> getNumbers(String numStr) {
		
        ArrayList<ImeiLocationResponseVO> validimeiList = new ArrayList<ImeiLocationResponseVO>();

		//ArrayList<String> validimeiList = new ArrayList<String>();
        ImeiLocationResponseVO vo = new ImeiLocationResponseVO();
		String sql="";
		 try {
			 conn = getConnection();
			   stmt = conn.createStatement();

			   if(numStr!=null){		
				   //Query to check the number string
				   sql="Select user_name,file_path from blynk_users  where imei_no in ("+numStr+")";
				   System.out.println(sql);
				   res = stmt.executeQuery(sql);
				   
				   	while(res.next()){				 
				   		vo.setName(res.getString("user_name"));
				   		vo.setImage(res.getString("file_path"));
				   		validimeiList.add(vo);
				   }
			   }
			   
	        } catch (SQLException se) {
	            se.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            closeResources(conn, stmt, res);
	        }
	        return validimeiList;
	}

}
