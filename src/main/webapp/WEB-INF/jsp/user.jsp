<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>User</title>
        <style>
            <%@include file="style.css" %>
        </style>
    </head>
    <body>
    <c:import url="navibar.jsp"/>
        <h2>User details</h2>
        <p>
        <table border=1 cellpadding=8>
        <tr>
            <th>ID</th>
            <td><c:out value="${user.id}"/></td>
        </tr>
        <tr>
            <th>E-mail</th>
            <td><c:out value="${user.email}"/></td>
        </tr>
        <tr>
            <th>Password</th>
            <td><c:out value="${user.password}"/></td>
        </tr>
        <tr>
            <th>First name</th>
            <td><c:out value="${user.firstName}"/></td>
        </tr>
        <tr>
            <th>Last name</th>
            <td><c:out value="${user.lastName}"/></td>
        </tr>
        <tr>
            <th>Role</th>
            <td><c:out value="${user.role.getRole()}"/></td>
        </tr>
        </table>
        </p>
    </body>
</html>