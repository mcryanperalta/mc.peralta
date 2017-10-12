
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Admission</title>
<style type="text/css">

#container {
	position: relative;
	width: 260px;
	height: 100px;
	left: 5px;
	border: solid black 1px;
	overflow: hidden;
}
#container:hover,input:hover {
	cursor: pointer;
}

#imgbox {
	position: absolute;
	width: 90px;
	height: 90px;
	left: 3px;
	top: 4px;
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
#hid {
	opacity: 0.001;
	font-size: 300%;
	top: -5px;
	right: -5px;
}
</style>
</head>
<body>

<fieldset style="width:270px" >
<h2 align="center">My Diary List</h2>
 <c:forEach items="${myData}" var="diary">
          <form action ="/SpringWebDiarylist/edit" method = "Post">
      <div id="container" class= "${diary.name}" onclick="getClassthenPass(this,'${diary.name}')">
      
     	<input id="holder" name="holder" type="hidden">
     	<script>
	function getClassthenPass(obj,abc) {
        document.getElementById("holder").value = obj.className;
        document.forms[0].submit();
	}
	
	
	</script>
	
        <img src = "C:\Users\user\Pictures\Camera Roll\WIN_20160729_16_59_19_Pro.jpg" id="imgbox" ></img>
     
	<br> <input type = "text" name = "title"  value = "Title: ${diary.name}" id = "imgtext" readonly onfocus="this.blur()" /><br>
	
	
	<input type = "text" name = "date"  value = "Date: ${diary.date}" id = "imgtext" readonly onfocus="this.blur()" /><br>
	
	<input type = "text" name = "StudentText"  value = "Text: ${diary.text}" id = "imgtext" readonly onfocus="this.blur()" />	<br>

	</div>

   
  	</form>
        </c:forEach>
        
        <form action ="/SpringWebDiarylist/new" method = "Post">
        <p align="center"> 	
        	<input type = "submit"  value = "Create new" style = "height:50px;width:100px"/>	<br>
      </p>
      
      </form>
  

      
       </fieldset> 
       


</body>
</html>