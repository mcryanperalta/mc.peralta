<!DOCTYPE HTML>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
<style type="text/css">


label { 
	display: table-cell; 
		}
#container,#imgInp {
	position: relative;
	width: 275px;
	height: 200px;
	left: 5px;
	border: 0px;
	overflow: hidden;
	
}

img:hover {
	cursor: pointer;
	
}

img{
	position: absolute;
	width: 200px;
	height: 190px;
	left:35px;
	top: 5px;
	border: solid black 1px;
	overflow: hidden;
}
#imgtext {
	position: absolute;
	left: 105px;
	
	border:0px;
	overflow: hidden;
}
#doit, #hid {
	position: absolute;
	cursor: default;
}
#doit {
	top: 0;
	left: 0;
	border: 0px ;
}
#imgInp {
	opacity: 0.001;
	font-size: 300%;
	top: -5px;
	right: -5px;
}
</style>

</head>

<body>

	<fieldset style="width:150px;" >
	 
	
<h2 align="center"> ${headMessage} </h2> 


       <form id="form1" runat="server">
       <div id="container" title="Choose File">
<div id="doit">
   
     <img id="blah" src="#" class = "imgbox" />
</div>
 <input type='file' id="imgInp" />
</div>
   
       
    </form>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<script charset = "UTF-8">
function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        
        reader.onload = function (e) {
                        $('#blah').attr('src', e.target.result);
                       document.getElementById("urlHolder").value = e.target.result;
                     console.log(e.target.result);
               }
        
        reader.readAsDataURL(input.files[0]);
       
    }
}

$("#imgInp").change(function(){
    readURL(this);


});
    </script>
	
<c:choose>
    <c:when test="${empty myData2}">
       <form action ="/SpringWebDiarylist/submitdata" method = "post">
       <input id="urlHolder" name="urlHolder" type="hidden">
<p><label for="a">Student's Name:</label> <input id ="a" type = "text" name = "title" value = "${diary.name} " style = "width:275px" /></p>
<p><label for="b">Student date:</label> <input id = "b" type = "text" name = "date"  value = "${diary.date}" style = "width:275px"  /></p>
<p><label for="c">Student text:</label><textarea id = "c" name="text" style="width:275px;height:150px" >${diary.text}</textarea></p>
<p align = "center"><input type = "submit" value ="Save" style = "height:50px;width:100px"/></p>

	</form>
	
    </c:when>
    <c:otherwise>
       <c:forEach items="${myData2}" var="diary">
	<form  method = "post">
	<input id="urlHolder" name="urlHolder" type="hidden">
 
<p><label for="a">Student's Name:</label> <input id ="a" type = "text" name = "title" value = "${diary.name}" style = "width:275px" /></p>
<p><label for="b">Student date:</label> <input id = "b" type = "text" name = "date"  value = "${diary.date}" style = "width:275px"   /></p>
<p><label for="c">Student text:</label><textarea id = "c" name="text" style="width:275px;height:150px" >${diary.text}</textarea></p>
	
	<p align="center"><input formaction ="/SpringWebDiarylist/submitdata"   type = "submit" value ="Save" style = "postion:absolute;height:50px;width:100px"/><input formaction ="/SpringWebDiarylist/delete" type = "submit" value ="Delete" style="postion:absolute;right:100px;height:50px;width:100px"></p>
	</form>
	</c:forEach>
	</c:otherwise>
	
</c:choose>



 

	

 	</fieldset>
 
  </body>
</html>