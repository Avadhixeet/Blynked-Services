package com.scolere.blynked.web.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.scolere.blynked.commonConstraints.ApplicationResource;
import com.scolere.blynked.persistance.dao.iface.getValidNumberDao;
import com.scolere.blynked.persistance.dao.impl.getValidNumberDaoImpl;
import com.scolere.blynked.web.VO.MobContact;
import com.scolere.blynked.web.VO.ResponceVO;

@SuppressWarnings("unused")
public class getValidNumber extends HttpServlet {
	
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ResponceVO responceVO = new ResponceVO();

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		getValidNumberDao validNumberDao = new getValidNumberDaoImpl();

		try{
			JSONParser parser = new JSONParser();


		//ArrayList<String> getNumberList = new ArrayList<String>();//if list of number read in arrayList
		//Object obj = parser.parse(new FileReader("C:\file1.json"));

		
			String line="";
			String requestData="";
			String mobileno=null;
			String numList="";
			
			BufferedReader reader = request.getReader();//Read from andriod device

			//BufferedReader reader = new BufferedReader(new FileReader("c:\\file1.txt"));//Hardcore data in text file for testing
			
			// Read the buffer string 
				while ((line = reader.readLine()) != null){
					System.out.println("line of numbers =="+line+"\n");
					requestData=requestData+line;
				}
				
				//read json object which is save in requestData......
				 JSONObject jObj = new JSONObject(requestData);
				 
				 StringBuffer temp=new StringBuffer();
				 //Read the json Array list in json object......
				 JSONArray jsonNumArr = jObj.getJSONArray("mobNumber");
				 for(int i=0;i<jsonNumArr.length();i++){
					 JSONObject number = jsonNumArr.getJSONObject(i);
					 //getNumberList.add(number.getString("Number"));
					 //System.out.println(number.getString("Number"));
					 temp.append("'").append(number.getString("Number")).append("'").append(",");//Append in String
				 }
				 
				 String numStr=temp.substring(0,temp.length()-1);
				 System.out.println("Generated num str = "+numStr);
				 
		ArrayList<String> getNumberListDetail = new ArrayList<String>();

		getNumberListDetail=validNumberDao.getNumbers(numStr);//calling method of database to check the value
		
		
		ArrayList<String> showElement = new ArrayList<String>();

		List<String> list = new ArrayList<String>(getNumberListDetail);//List for responseList
		 for (String temp2 : list){
			 showElement.add(temp2);
			 System.out.println("showElement"+showElement);
	        }
		responceVO.setStatus(ApplicationResource.status_success);
		responceVO.setCode(ApplicationResource.status_success_code);
		responceVO.setResponseList(showElement);
		String responseObj = new Gson().toJson(responceVO);	
		System.out.println(responseObj);
		out.print(responseObj);				
		}
		catch (Exception e) {
			 responceVO.setStatus(ApplicationResource.status_failure);
				responceVO.setCode(ApplicationResource.status_failure_code);
				responceVO.setResponseList(null);
				String responseObj = new Gson().toJson(responceVO);
				System.out.println(responseObj);
				out.print(responseObj);
			e.printStackTrace();
		}
	}
	

	public ResponceVO getResponceVO() {
		return responceVO;
	}

	public void setResponceVO(ResponceVO responceVO) {
		this.responceVO = responceVO;
	}

 
}
