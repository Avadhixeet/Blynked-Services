/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scolere.blynked.web.controller;

import com.scolere.blynked.web.VO.TrackerVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dell
 */
public class MapLocator extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Inside MapLocator >>>> ");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            //Get imei no from request path
                String pathInfo = request.getPathInfo(); // /imeino
                System.out.println("Path info = "+pathInfo);
                String imeiNo=pathInfo.substring(1);
                System.out.println("IMEI NO = "+imeiNo);
                
            //Get imei no from the context
                TrackerVO vo = (TrackerVO) getServletContext().getAttribute(imeiNo);
                
                if(vo != null)
                {
                    System.out.println("SHOW MAP");
                    //getServletContext().setAttribute("userVo", vo);
                    response.sendRedirect("../jsp/InitiateTracker.jsp?exec="+imeiNo);  
                    
//                    RequestDispatcher rd = request.getRequestDispatcher("/jsp/InitiateTracker.jsp");
//                    rd.forward(request, response);   
                    
                }else{
                    out.println("The Glympse "+imeiNo+" is no longer available.");
                }            
            
            
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
