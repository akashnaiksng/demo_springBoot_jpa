<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<form action="addAlien" method="get">
		<table>
			<tr>
				<td>ID:</td>
				<td><input type="text" name="aid"></td>
			</tr>
			<tr>
				<td>NAME:</td>
				<td><input type="text" name="aname"></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>


	<form action="getAlien" method="get">
		<table>
			<tr>
				<td>Find By ID:</td>
				<td><input type="text" name="aid"></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit">
				<td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>