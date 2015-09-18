package com.scolere.blynked.web.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.scolere.blynked.commonConstraints.ApplicationResource;
import com.scolere.blynked.web.VO.ImeiLocationResponseVO;
import com.scolere.blynked.web.VO.ResponceVO;
import com.scolere.blynked.web.VO.TrackerVO;

/**
 * Servlet implementation class GetLocationByImeiNo
 */
@WebServlet("/getLocationByImeiNo")
public class GetLocationByImeiNo extends HttpServlet{
	private static final long serialVersionUID = 1L;
	ResponceVO responceVO = new ResponceVO();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetLocationByImeiNo() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		List<ImeiLocationResponseVO> getLocationListDetail = new ArrayList<ImeiLocationResponseVO>();

		try{
			//JSONParser parser = new JSONParser();
			
			String line="";
			String requestData="";
			String imeiNo=null;
			
			//BufferedReader reader = request.getReader();//Read from andriod device

			BufferedReader reader = new BufferedReader(new FileReader("c:\\file2.txt"));//Hardcore data in text file for testing

			// Read the buffer string 
			while ((line = reader.readLine()) != null){
				System.out.println("line of numbers =="+line+"\n");
				requestData=requestData+line;
			}
			//read json object which is save in requestData......
			 JSONObject jObj = new JSONObject(requestData);
			 // json string format in request  {"IMEI":[{"imei":"9876543"}]
			
			 //Read the json Array list in json object......
			 JSONArray jsonNumArr = jObj.getJSONArray("IMEI");
			 
			 ImeiLocationResponseVO imeiVo = null;
			 for(int i=0;i<jsonNumArr.length();i++){
				 
				 JSONObject number = jsonNumArr.getJSONObject(i);
				// getNumberList.add(number.getString("Number"));
				 System.out.println(number.getString("imei"));
				 imeiNo= number.getString("imei");
				 TrackerVO vo = (TrackerVO )getServletContext().getAttribute(imeiNo);//from servlet Context
				 if(vo!=null)
				 {
				 imeiVo = new ImeiLocationResponseVO();
					imeiVo.setName(vo.getUserName());    //from context or TrackerVO
					imeiVo.setImage(vo.getProfileImage());
					imeiVo.setLocLat(vo.getCurrentLocationLat());
					imeiVo.setLocLong(vo.getCurrentLocationLong());
					
					getLocationListDetail.add(imeiVo);    //added into list
				 }
			 }
	
				//send response.......
				responceVO.setStatus(ApplicationResource.status_success);
				responceVO.setCode(ApplicationResource.status_success_code);
				responceVO.setTrackerResponseList(getLocationListDetail);
				
				String responseObj = new Gson().toJson(responceVO);	
				System.out.println(responseObj);
				out.print(responseObj);	

			
		}catch(Exception e){
			responceVO.setStatus(ApplicationResource.status_failure);
			responceVO.setCode(ApplicationResource.status_failure_code);
			responceVO.setTrackerResponseList(null);

			String responseObj = new Gson().toJson(responceVO);
			System.out.println(responseObj);
			out.print(responseObj);
			e.printStackTrace();
			
		}
	}

}
