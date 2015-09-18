<!DOCTYPE html>

<!--<meta http-equiv="refresh" content="30">-->

<%@ page import="com.scolere.blynked.web.VO.TrackerVO"%>
<%
    String imei=request.getParameter("exec");
    System.out.println("Exec = "+imei);
    
    TrackerVO vo = (TrackerVO) getServletContext().getAttribute(imei);
    System.out.println("VO = "+vo);
    request.setAttribute("userVo", vo);
%>
<html>
<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<meta charset="utf-8">
<title>Location</title>
<style>
html,body,#map-canvas {
	height: 100%;
	margin: 0px;
	padding: 0px
}
</style>
<!-- <script
	src="https://maps.googleapis.com/maps/api/js?v=3.exp&signed_in=true"></script>
	 -->
	<script
src="http://maps.googleapis.com/maps/api/js">
</script>
<script>
var currentone ;
var directionsDisplay;
var directions;
var directionsService = new google.maps.DirectionsService();
var map;
var currentMarker;
var imeiNo ='${userVo.imeiNo}';
var startLatitude =${userVo.startLocationLat};
  var startLontitude =${userVo.startLocationLong };
  var currentLatitude =${userVo.currentLocationLat };
  var currentLontitude =${userVo.currentLocationLong };
  var endLatitude =${userVo.endLocationLat };
  var endLontitude =${userVo.endLocationLong };

 var flightPlanCoordinatessss = [
    new google.maps.LatLng(startLatitude, startLontitude),
    new google.maps.LatLng(currentLatitude, currentLontitude)
  ];
	 

function initialize() {
  var delhiss = new google.maps.LatLng(startLatitude, startLontitude);

var start = new google.maps.LatLng(startLatitude, startLontitude);
	 var current = new google.maps.LatLng(currentLatitude, currentLontitude);
	 var end = new google.maps.LatLng(endLatitude, endLontitude);
	 

 
		  var mapOptions = {
		     	center: flightPlanCoordinatessss,
				 zoom:18,
				/* zoomControl: false, scrollwheel: false, disableDoubleClickZoom: true, */
			     mapTypeId: google.maps.MapTypeId.ROADMAP,
		  }
		  
		  var flightPlanCoordinates = [
    new google.maps.LatLng(startLatitude, startLontitude),
    new google.maps.LatLng(currentLatitude, currentLontitude)
  ];
  
   var flightPlanCoordSecond = [
    new google.maps.LatLng(currentLatitude, currentLontitude),
     new google.maps.LatLng(endLatitude,endLontitude)
  ];
  
  
     directions = new google.maps.DirectionsRenderer({polylineOptions: {
      strokeColor: "green",
       path: flightPlanCoordinates,
           }
       });

  directionsDisplay = new google.maps.DirectionsRenderer({polylineOptions: {
      strokeColor: "yellow",
       path: flightPlanCoordSecond,
           }
       });
  
     
		  
  map = new google.maps.Map(document.getElementById('map-canvas'),  mapOptions);

  mapPath(startLatitude,startLontitude,currentLatitude,currentLontitude,endLatitude,endLontitude);
}

function mapPath(startLat,startLong,currentLat,currentLong,endLat,endLong) {
	var start = new google.maps.LatLng(startLat,startLong);
	var current = new google.maps.LatLng(currentLat,currentLong);
	var end =  new google.maps.LatLng(endLat,endLong);
	
	
  
   var requestFirst = {
      origin: start,
      destination: current,
     // waypoints:  wayptstart,
      optimizeWaypoints: true,
      travelMode: google.maps.TravelMode.DRIVING,
  };
  
   var requestSecond = {
      origin: current,
      destination: end,
     // waypoints:  wayptstart,
      optimizeWaypoints: true,
      travelMode: google.maps.TravelMode.DRIVING,
  };
  
 
   directionsService.route(requestFirst, function(response, status) {
    if (status == google.maps.DirectionsStatus.OK) {
      directions.setDirections(response);
     directions.setOptions( { suppressMarkers: false}  );
     directions.setOptions({ preserveViewport: true });
      directions.suppressMarkers = true;
     
    }
  });
  
  
  directionsService.route(requestSecond, function(response, status) {
    if (status == google.maps.DirectionsStatus.OK) {
      directionsDisplay.setDirections(response);
     directionsDisplay.setOptions( { suppressMarkers: false}  );
     directionsDisplay.setOptions({ preserveViewport: true });
      directionsDisplay.suppressMarkers = true;
    }
  
  });
  
   
  
    var startone = new google.maps.Marker({
      location: start,
      position: start, 
      icon: 'http://maps.google.com/mapfiles/ms/icons/green-dot.png',
      map: map,
	  title:"start position",
   	
  });
  
   currentone = new google.maps.Marker({
      location: current,
      position: current, 
      icon: 'current-location.png',
      map: map,
	  title:"current position",
   	
  });
  
  var endone = new google.maps.Marker({
      location: end,
      position: end, 
      icon: 'http://maps.google.com/mapfiles/ms/icons/red-dot.png',
      map: map,
	  title:"end position",
   	
  });
  
  
  
  
   directions.setMap(map);
  directionsDisplay.setMap(map);
  map.setCenter(start);
    map.setCenter(end);
      map.setCenter(current);
  
  setTimeout("moveMarker()", 6000);
  
}

function moveMarker() {
var datas = "";
var url="http://localhost:8080/Blynk/TrackUser?imeiNo="+imeiNo;
  	$.ajax({
	method	:	"GET",
	url		:	url,
	data	:	"",
	 beforeSend : function(){
	 currentone.setMap(null);
	 },
	success	:	function(result){ 
	var resp = result.split(",");
	var currentLat = resp[0];
	var currentLati = parseFloat(currentLat);
	var currentLon=resp[1];
	var currentLontit=parseFloat(currentLon);
	
	currentLatitude =currentLati;
	currentLontitude=currentLontit; 
	
	mapPath(startLatitude,startLontitude,currentLatitude,currentLontitude,endLatitude,endLontitude);
	 
	},
	complete	:	function(){
	}
	}); 
}
google.maps.event.addDomListener(window, 'load', initialize);

    </script>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
</head>
<body>
	<div id="map-canvas"></div>
</body>
</html>