<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Save Producer</title>
        <style>
            <%@include file="style.css" %>
        </style>
    </head>
    <body>
    <c:import url="navibar.jsp"/>
        <h2>Producer parameters:</h2>
        <p>
        <c:if test="${mode == 0}">
            <form name="producerSaveForm" method="get" action="saveProducer" >
                Name: <input type="text" name="name"/> <br/>

                <input type="submit" value="Add producer" class="button"/>
            </form>
        </c:if>
        <c:if test="${mode == 1}">
            <form name="producerUpdateForm" method="put" action="producers">
                ID: <input readonly type="text" name="id" value=${producer.id} /> <br/>
                New name: <input type="text" name="name" value=${producer.name} /> <br/>

                <input type="submit" value="Update producer" class="button"/>
            </form>
        </c:if>
        </p>
    </body>
</html>