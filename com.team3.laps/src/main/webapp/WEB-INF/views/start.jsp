<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>Welcome ${requestScope.name}</h1>
<P> <a href="${pageContext.request.contextPath}/applyleave/annual">Apply Annual Leave</a></P>
<P> <a href="${pageContext.request.contextPath}/applyleave/medical">Apply Medical Leave</a></P>
</body>
</html>
