package com.scolere.blynked.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scolere.blynked.web.VO.TrackerVO;

/**
 * Servlet implementation class StopShare
 */

public class StopShare extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StopShare() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println("Inside get...Stop share "+request.getParameter("imeiNo"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/jsp");
		PrintWriter out= response.getWriter();
		 System.out.println("Inside get...Stop share "+request.getParameter("imeiNo"));
		 try{
              TrackerVO vo = (TrackerVO) getServletContext().getAttribute(request.getParameter("imeiNo"));
            
            	 
            	 if(vo != null)
                 {
                 System.out.println("Previous data = "+vo);
                 String imeiNo = request.getParameter("imeiNo");
                 vo.setImeiNo(null);
                 System.out.println("Updated data.."+vo);
                 out.println("Success");

                 }else{
                	 System.out.println("Tracking for "+request.getParameter("imeiNo")+" is not initiated yet.");
                 out.println("Tracking for "+request.getParameter("imeiNo")+" is not initiated yet.");
                 }
             }
             catch (Exception e) {
				e.printStackTrace();
			}
		
	}

}
