<html>
<head>
</head>
<body>

<form method="post" enctype="multipart/form-data" id="submitFormDetail">
Name:<br>
<input type="text" name="username">
<br>
phone No:<br>
<input type="text" name="mobileNum">
<br>
Email Id:<br>
<input type="email" name="emailId">
<br>
Device Name:<br>
<input type="text" name="deviceName">
<br>
OS:<br>
<input type="text" name="os">
<br>
Software version:<br>
<input type="text" name="softVersion">
<br>
Imei NO:<br>
<input type="text" name="imeiNo">
<br>
Upload Image:<br>
<input type="file" name="file">
<br>
<input type="button" value="Save" onclick="return saveDetail()">
</form>
</body>
</html>

<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.3.min.js"></script>
<script type="text/javascript">

function saveDetail(){
 var formData = new FormData($("#submitFormDetail")[0]);
					  $.ajax({
					            url: 'uploadController',
					            type: 'POST',
					            data: formData,
					            cache: false,
					            contentType: false,
					            processData: false,
					            success: function (result) {
					            alert(result);
					                
					            },
					            error: function(result){ }
					           
					        });
					        return false;
					        }
					        
					        </script>
