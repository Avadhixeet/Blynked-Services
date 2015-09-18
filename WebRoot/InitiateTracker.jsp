<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.scolere.blynked.web.VO.TrackerVO" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor=lightblue>
<table>
<thead>
<tr><td>Attributes</td><td>Values</td></tr></thead>
<tbody>
<tr><td>IMEI NO</td><td><c:out value="${abc.imeiNo}"/></td></tr>
<tr><td>START LOCATION LATITUDE</td><td><c:out value="${abc.startLocationLat}"/> </td></tr>
<tr><td>START LOCATION LONGITUDE</td><td><c:out value="${abc.startLocationLong }"/></td></tr>
<tr><td>END LOCATION LATITUDE</td><td><c:out value="${abc.endLocationLat }"/></td></tr>
<tr><td>END LOCATION LONGITUDE</td><td><c:out value="${abc.endLocationLong }"/></td></tr>
<tr><td>USER NAME</td><td><c:out value="${abc.userName }"/></td></tr>
<tr><td>PROFILE IMAGE</td><td><c:out value="${abc.profileImage }"/></td></tr>
<tr><td>CONTACT NO</td><td><c:out value="${abc.contactNo }"/></td></tr>
<tr><td>CURRENT LOCATION LATITUDE</td><td><c:out value="${abc.currentLocationLat }"/></td></tr>
<tr><td>CURRENT LOCATION LONGITUDE</td><td><c:out value="${abc.currentLocationLong }"/></td></tr>
</tbody>
</table>
<a href="TrackUser.html">Track User</a>
</body>
</html>