<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Save User</title>
        <style>
            <%@include file="style.css" %>
        </style>
    </head>
    <body>
    <c:import url="navibar.jsp"/>
        <h2>User parameters:</h2>
        <p>
        <c:if test="${mode == 0}">
            <form name="userSaveForm" method="post" action="users" >
                E-mail: <input type="text" name="email"/> <br/>
                Password: <input type="text" name="password"/> <br/>
                First Name: <input type="text" name="firstName"/> <br/>
                Last Name: <input type="text" name="LastName"/> <br/>
                Role: <select name="role"> "S{roles}"
                    <c:forEach items="${roles}" var="role">
                        <option value=${role.getRole()} > ${role.getRole()} </option>
                    </c:forEach>
                </select>
                <br/>

                <input type="submit" value="Add user" class="button"/>
            </form>
        </c:if>
        <c:if test="${mode == 1}">
            <form name="userUpdateForm" method="put" action="users">
                ID: <input readonly type="text" name="id" value=${user.id} /> <br/>
                New e-mail: <input type="text" name="email" value=${user.email} /> <br/>
                New password: <input type="text" name="password" value=${user.password} /> <br/>
                New first name: <input type="text" name="firstName" value=${user.firstName} /> <br/>
                New last name: <input type="text" name="lastName" value=${user.lastName} /> <br/>
                Role: <select name="role"> "S{roles}"
                    <c:forEach items="${roles}" var="role">
                        <option value=${role.getRole()} > ${role.getRole()} </option>
                    </c:forEach>
                </select>
                <br/>

                <input type="submit" value="Update user" class="button"/>
            </form>
        </c:if>
        </p>
    </body>
</html>