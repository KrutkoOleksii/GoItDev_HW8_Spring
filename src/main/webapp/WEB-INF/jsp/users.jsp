<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Users</title>
        <style>
            <%@include file="/style.css" %>
        </style>
    </head>
    <body>
    <c:import url="/navibar.jsp"/>
        <h2>Users</h2>
        <p>
        <table border=1 cellpadding=8>
        <tr>
             <th>ID</th>
             <th>E-mail</th>
             <th>Password</th>
             <th>First name</th>
             <th>Last name</th>

             <th>"UPDATE"</th>
             <th>"DELETE"</th>
        </tr>
        <c:forEach var="user" items="${users}">
             <tr>
             <td><c:out value="${user.id}"/></td>
             <td><c:out value="${user.email}"/></td>
             <td><c:out value="${user.password}"/></td>
             <td><a href="${PageContext.request.contextPath}/find?id=${user.id}"><c:out value="${user.firstName}"/></a></td>
             <td><c:out value="${user.lastName}"/></td>

             <td><button onclick="location.href='/updateUser?id=${user.id}'"  class="button"/>UPDATE</button></td>
             <td><button onclick="location.href='/delete?id=${user.id}'"  class="button"/>DELETE</button></td>
             </tr>
        </c:forEach>
        </table>
        </p>
    </body>
</html>