<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Apply Annual Leave</title>
</head>
<body>
	<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
	<script>
		$(document).ready(function() {
			$("#datepicker1").datepicker({
				dateFormat : "yy/mm/dd"
			});
		});
		$(document).ready(function() {
			$("#datepicker2").datepicker({
				dateFormat : "yy/mm/dd"
			});
		});
	</script>
	<h1>Apply Annual Leave</h1>
	<form:form
		action="${pageContext.request.contextPath}/applyleave/annual"
		modelAttribute="leave">
		<table>
			<tr>
				<td>Leave From:</td>
				<td><form:input path="leaveFrom" id="datepicker1" /> <form:errors
						path="leaveFrom" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>Leave To:</td>
				<td><form:input path="leaveTo" id="datepicker2" /> <form:errors
						path="leaveTo" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>Leave Days:</td>
				<td><form:input path="" placeholder="0" /></td>
				<td><form:button id="cal" name="calculate" value="Calculate"
						type="submit" /></td>
			</tr>
			<tr>
				<td>Additional Reasons</td>
				<td><form:input path="additionalReasons" /></td>
			</tr>
			<tr>
				<td>Work dissemination(if any)</td>
				<td><form:input path="workDessimination" /></td>
			</tr>
			<tr>
				<td>Contact Details(if overseas)</td>
				<td><form:input path="contactDetails" /></td>
			</tr>
			<tr>
				<td><input name="submit" type="submit" value="Submit" /></td>
				<td><input name="clear" type="reset" value="Clear" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>