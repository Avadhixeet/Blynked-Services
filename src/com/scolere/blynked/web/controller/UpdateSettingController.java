package com.scolere.blynked.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.scolere.blynked.persistance.dao.iface.UploadDetailDao;
import com.scolere.blynked.persistance.dao.impl.UploadDetailDaoImpl;


public class UpdateSettingController extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	UploadDetailDao uploadDetailDao;
	
	   private File file ;
	
	public void destroy() {
		super.destroy(); 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String uploadImage = "C:/blynk/userRegistration/images/";
		String username="";
	    String mobileNum="";
	    String filePath="";
	    String imageFileName = "";
	    //String regId="";

		uploadDetailDao = new UploadDetailDaoImpl();

		try{
	             
	             DiskFileItemFactory factory = new DiskFileItemFactory();
	             ServletFileUpload upload = new ServletFileUpload(factory);
        		 List fileItems = upload.parseRequest(request);
	             Iterator i = fileItems.iterator();
	             while (i.hasNext()) 
	             {
	                FileItem fi = (FileItem)i.next();
	                
	                   System.out.println( fi.getFieldName() + "   " +fi.getString());
	                   if(fi.getFieldName().equalsIgnoreCase("mobileNum")){
	                	   mobileNum = fi.getString();
		                 }
	                   if(fi.getFieldName().equalsIgnoreCase("username")){
		                	 username = fi.getString();
		                 }
		                
	                	//Write file 
		                	  imageFileName = fi.getName();
		               if(imageFileName!=null){
	                	    filePath=uploadImage+imageFileName;
	                   	   //Check if uploadImage folder is available or not. if not create new one.
	                	   new File(uploadImage).mkdirs();
	 	                   file = new File( filePath) ;
	 	                   fi.write( file ) ;
		               	   }
       
	                }	
	             		System.out.println("Upload image path = "+filePath);

	                uploadDetailDao.updateDetail(username,filePath,mobileNum);
	                   out.println("success");

	                } catch (Exception e) {
	        	 System.out.println("Exception "+e);
	        	  out.println("Error");
				e.printStackTrace();
			}
	}
}
