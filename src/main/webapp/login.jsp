<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<title>Users Login</title>
	</head>

	<body>

		<h1><strong>Users Login</strong></h1>
        <div>
		<c:url value="/login" var="login"/>
		<form:form action="" method="post">
			<label>Username:</label> <input type="text" name="username" />
			<label>Password:</label> <input type="password" name="password" />
			<input type="submit" value="LOGIN"/>
		</form:form>
		</div>

        <div>
		<c:url value="/register" var="register"/>
        <form:form action="" method="get">
        	<p>
            <td><a href="${PageContext.request.contextPath}/user/register"><c:out value="REGISTER"/></a></td>
            </p>
        </form:form>
        </div>

	</body>
</html>