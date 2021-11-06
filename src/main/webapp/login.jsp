<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<title>Users Login</title>
	</head>

	<body>

		<h1><strong>Users Login</strong></h1>

		<c:url value="/login" var="login"/>

		<form:form action="" method="post">
			<label>Username:</label> <input type="text" name="username" />
			<label>Password:</label> <input type="password" name="password" />
			<input type="submit" name = "LOGIN"/>
		</form:form>
	</body>
</html>