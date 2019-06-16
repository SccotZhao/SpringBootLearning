<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="addAlien">
		<input type="text" name = "aid"><br>
		<input type="text" name="aname"><br>
		<input type="text" name="atech"><br>
		<input type ="submit" value = "Add"><br>
	</form>

	<form action="getAlien">
		<input type="text" name = "aid"><br>
		<input type ="submit" value="Get"><br>
	</form>
	
		<form action="deleteAlien">
		<input type="text" name = "aid"><br>
		<input type ="submit" value="Delete"><br>
	</form>
	
</body>
</html>