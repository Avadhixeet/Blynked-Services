
package com.scolere.blynked.persistance.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.scolere.blynked.persistance.dao.iface.BlynkDao;
import com.scolere.blynked.persistance.factory.LmsDaoAbstract;


public class BlynkDaoImpl extends LmsDaoAbstract implements BlynkDao {

	
	 Connection conn = null;
	 Statement stmt = null;
	
	@Override
	public String getById(int userId) {
		String sql="";
		 try {
			   conn = getConnection();
			   stmt = conn.createStatement();
			   
			   /* execute query code */
			   
	            stmt.executeUpdate(sql);
	        } catch (SQLException se) {
	            se.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            closeResources(conn, stmt, null);
	        }
	        return null;
	}
	@Override
	public String getAll() {
		String sql="";
		 try {
			   conn = getConnection();
			   stmt = conn.createStatement();
			   
			   /* execute query code */
			   
	            stmt.executeUpdate(sql);
	        } catch (SQLException se) {
	            se.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            closeResources(conn, stmt, null);
	        }
	        return null;
	}
	@Override
	public String save() {
		String sql="";
		 try {
			   conn = getConnection();
			   stmt = conn.createStatement();
			   
			   /* execute query code */
			   
	            stmt.executeUpdate(sql);
	        } catch (SQLException se) {
	            se.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            closeResources(conn, stmt, null);
	        }
	        return null;
	}
	@Override
	public String updatById(int userId) {
		String sql="";
		 try {
			   conn = getConnection();
			   stmt = conn.createStatement();
			   
			   /* execute query code */
			   
	            stmt.executeUpdate(sql);
	        } catch (SQLException se) {
	            se.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            closeResources(conn, stmt, null);
	        }
	        return null;
	}
	
	
	
}//end of class
