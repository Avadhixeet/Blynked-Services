package com.scolere.blynked.web.controller;

import com.scolere.blynked.web.VO.TrackerVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitiateTracker
 */
public class InitiateTracker extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitiateTracker() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Inside InitiateTracker >>>> ");
        resp.setContentType("text/jsp");  
        PrintWriter out = resp.getWriter();
        
        try{
        	
        	//Request Parameters....
    	    String imeiNo=request.getParameter("imeiNo");
    	    String startLocationLatStr=request.getParameter("startLoclat");
    	    String startLocationLongStr=request.getParameter("startLoclong");
    	    String endLocationLatStr=request.getParameter("endLoclat");
    	    String endLocationLongStr=request.getParameter("endLoclong");
    	    String userName=request.getParameter("userName");
    	    String profileImage=request.getParameter("profImage");
    	    String contactNo=request.getParameter("contactNo");
    	    String currentLocationLatStr = request.getParameter("currentLocLat");
    	    String currentLocationLongStr = request.getParameter("currentLocLong");
          
    	    //parsing the lat long 
    	    double startLocationLat = Double.parseDouble(startLocationLatStr);
    	    double startLocationLong = Double.parseDouble(startLocationLongStr);
    	    double endLocationLat = Double.parseDouble(endLocationLatStr);
    	    double endLocationLong = Double.parseDouble(endLocationLongStr);
    	    double currentLocationLat = Double.parseDouble(currentLocationLatStr);
    	    double currentLocationLong = Double.parseDouble(currentLocationLongStr);
    	     	   
    	    TrackerVO vo =new TrackerVO();
    	    
    	    //set the parameters in vo
    		vo.setImeiNo(imeiNo);
    		vo.setStartLocationLat(startLocationLat);
    		vo.setStartLocationLong(startLocationLong);
    		vo.setEndLocationLat(endLocationLat);
    		vo.setEndLocationLong(endLocationLong);
    		vo.setUserName(userName);
    		vo.setProfileImage(profileImage);
    		vo.setContactNo(contactNo);
    		vo.setCurrentLocationLat(currentLocationLat);
    		vo.setCurrentLocationLong(currentLocationLong);
    		request.setAttribute("imeissNo", vo);
    		getServletContext().setAttribute(imeiNo, vo);
    		getServletContext().setAttribute("userVo", vo);
    		//sendRedirect on InitiateTracker.jsp
    	    System.out.println("Tracker Started");
    	    resp.sendRedirect("jsp/InitiateTracker.jsp?exec="+imeiNo);//when send by Initiate.html file for locahost
    	   // out.println("success");
        }catch(Exception e){
            System.out.println("Error - "+e);
             out.println("Failure");
        }
        
    }
    
    
}//End of class
 