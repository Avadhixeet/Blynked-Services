package com.scolere.blynked.web.controller;

import com.scolere.blynked.web.VO.TrackerVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TrackUser
 */
public class TrackUser extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrackUser() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
               System.out.println("Inside get...param emieno "+request.getParameter("imeiNo"));
	      PrintWriter out = response.getWriter();
	      
               TrackerVO vo = (TrackerVO) getServletContext().getAttribute(request.getParameter("imeiNo"));
               String temp=vo.getCurrentLocationLat()+","+vo.getCurrentLocationLong();
	       out.print(temp);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Inside TrackUser >>>> ");
        resp.setContentType("text/jsp");  
        PrintWriter out = resp.getWriter();
        
        try{        
        TrackerVO vo = (TrackerVO) getServletContext().getAttribute(request.getParameter("imeiNo"));
        
        if(vo != null)
        {
        System.out.println("Previous data = "+vo);
        
        String imeiNo = request.getParameter("imeiNo");
//        String startLocationLatStr = request.getParameter("startLoclat");
//        String startLocationLongStr = request.getParameter("startLoclong");
//        String endLocationLatStr = request.getParameter("endLoclat");
//        String endLocationLongStr = request.getParameter("endLoclong");
        String currentLocationLatStr = request.getParameter("currentLocLat");
        String currentLocationLongStr = request.getParameter("currentLocLong");

//        double startLocationLat = Double.parseDouble(startLocationLatStr);
//        double startLocationLong = Double.parseDouble(startLocationLongStr);
//        double endLocationLat = Double.parseDouble(endLocationLatStr);
//        double endLocationLong = Double.parseDouble(endLocationLongStr);
        double currentLocationLat = Double.parseDouble(currentLocationLatStr);
        double currentLocationLong = Double.parseDouble(currentLocationLongStr);

        vo.setImeiNo(imeiNo);
//        vo.setStartLocationLat(startLocationLat);
//        vo.setStartLocationLong(startLocationLong);
//        vo.setEndLocationLat(endLocationLat);
//        vo.setEndLocationLong(endLocationLong);
        vo.setCurrentLocationLat(currentLocationLat);
        vo.setCurrentLocationLong(currentLocationLong);

        getServletContext().setAttribute(imeiNo, vo);

        System.out.println("Updated data.."+vo);
        out.println("Success");

        }else{
        out.println("Tracking for "+request.getParameter("imeiNo")+" is not initiated yet.");
        }
        
        }catch(Exception e){
            System.out.println("Error - "+e);
             out.println("Failure");
        }
    }
    
}//End of class
