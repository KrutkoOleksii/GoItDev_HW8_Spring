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
            <form name="userRegisterForm" method="post" action="register" >
                E-mail: <input type="text" name="email"/> <br/>
                Password: <input type="text" name="password"/> <br/>
                First Name: <input type="text" name="firstName"/> <br/>
                Last Name: <input type="text" name="LastName"/> <br/>

                <input type="submit" value="Register" class="button"/>
            </form>
        </p>
    </body>
</html>