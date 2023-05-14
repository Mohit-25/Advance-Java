<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>

 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
 <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
 <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>	


<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.error
{
   
   color: red;
}
</style>
</head>
<body>
<form action="registration" method="post">
	
	<%
	   //String Error=(String)request.getAttribute("error");
	   String firstname=(String)request.getAttribute("firstname");
	   String lastname=(String)request.getAttribute("lastname");
	   String email=(String)request.getAttribute("email");
	   String password=(String)request.getAttribute("password");
	   String cpassword=(String)request.getAttribute("cpassword");
	   String city=(String)request.getAttribute("city");
	   String gender=(String)request.getAttribute("gender");
	   String hobby=(String)request.getAttribute("hobby");
	   
	   
	
	   
	   
	
	%> 
	
	
	 First Name: <input type="text" name="firstName" value="${bean.firstName}"><span class='error'><%=firstname==null?"": " "+firstname %> </span><br/><br/>
	 Last Name:  <input type="text" name="lastName" value="${bean.lastName}"><span class='error'><%=lastname==null?"":lastname %> </span><br/><br/>
	 Email Id:   <input type="text" name="emailId" value="${bean.emailId}"><span class='error'><%=email==null?"":email %> </span><br/><br/>
	 Password:   <input type="text" name="password" ><span class='error'><%=password==null?"":password %> </span><br/><br/>
	 Confirm Password: <input type="text" name="cpassword"><span class='error'><%=cpassword==null?"":cpassword %> </span><br/><br/>
	 City: <select name="city">
	        <option value="select">Select</option>
            <option  value="Ahmedabad">Ahmedabad</option>
            <option value="surat" >Surat</option>
            <option value="vadodara">Vadodara</option>
            </select><span class='error'><%=city==null?"":city %> </span><br/><br/>
	 Gender:<input type="radio" name="gender" value="m">Male
	       <input type="radio" name="gender" value="f">Female<span class='error'><%=gender==null?"":gender%> </span><br/><br/>
	 Hobby:<input type="checkbox" name="h1" value="cooking">Cooking
	       <input type="checkbox" name="h2" value="crafting">Crafting
	       <input type="checkbox" name="h3" value="dancing">Dancing<span class='error'><%=hobby==null?"":hobby %> </span><br/><br/>
	       
	       <input type="submit" value="Register">
	   </form>    
	 <div class="dropdown">
    <button class="btn btn-secondary dropdown-toggle" type="button" id="technologiesDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        Technologies Learned
    </button>
    <div class="dropdown-menu" aria-labelledby="technologiesDropdown">
        <div class="dropdown-checkboxes">
            <input type="checkbox" id="javaCheckbox" name="technologies" value="Java">
            <label for="javaCheckbox">Java</label>
            <br>
            <input type="checkbox" id="pythonCheckbox" name="technologies" value="Python">
            <label for="pythonCheckbox">Python</label>
            <br>
            <input type="checkbox" id="javascriptCheckbox" name="technologies" value="JavaScript">
            <label for="javascriptCheckbox">JavaScript</label>
            <br>
            <input type="checkbox" id="phpCheckbox" name="technologies" value="PHP">
            <label for="phpCheckbox">PHP</label>
        </div>
    </div>
</div>
	 
	      
	  


</body>
</html>