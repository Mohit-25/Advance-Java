<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   <form action="Authentication" method="post">
   Email Id:<input type="text" name="email">
   Password:<input type="text" name="password">
   <input type="submit" value="Submit">
   </form>
   ${error}

</body>
</html>