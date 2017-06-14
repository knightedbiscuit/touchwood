<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
</head>
<body>
	<h1>${message}</h1>
	<p>You have applied for ${leavecount}days of ${leavetype} Leave from ${leavefrom} to ${leaveto}. </p>
	<a href="${pagecontext.request.contextpath}/laps/home/start">Continue</a>

</body>
</html>