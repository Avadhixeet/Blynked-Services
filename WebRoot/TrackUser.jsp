<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="com.scolere.blynked.web.VO.TrackerVO" %>
<%@ page import="java.util.Enumeration" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Active users</title>
</head>
<body bgcolor=lightblue>
<h2>Active users</h2>
<table border="1">
<thead>
<tr><td>IMEI NO</td><td>USERNAME</td></tr></thead>
<tbody>
    

<%  
Enumeration e = getServletContext().getAttributeNames();
while (e.hasMoreElements()) {

	String attrName=(String)e.nextElement();
	Object temp= getServletContext().getAttribute(attrName);
	
	if(temp instanceof TrackerVO)
	{
	TrackerVO vo = (TrackerVO)temp;
        System.out.println(vo);
	out.println("<tr><td>"+vo.getImeiNo()+ "</td> <td> " +vo.getUserName()+ "</td> </tr>");
	}
  } 
  %>

</tbody>
</table>

</body>
</html>