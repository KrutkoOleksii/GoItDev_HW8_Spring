<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Save Product</title>
        <style>
            <%@include file="style.css" %>
        </style>
    </head>
    <body>
    <c:import url="navibar.jsp"/>
        <h2>Product parameters:</h2>
        <p>
        <c:if test="${mode == 0}">
            <form name="productSaveForm" method="post" action="products" >
                Name: <input type="text" name="name"/> <br/>
                Producer: <select name="producerList"> "S{producers}"
                    <c:forEach items="${producers}" var="producer">
                    <option value=${producer.id} > ${producer.name} </option>
                    </c:forEach>
                </select>
                <br/>

                <input type="submit" value="Add product" class="button"/>
            </form>
        </c:if>
        <c:if test="${mode == 1}">
            <form name="productUpdateForm" method="put" action="products">
                ID: <input readonly type="text" name="id" value=${product.id} /> <br/>
                New name: <input type="text" name="name" value=${product.name} /> <br/>

                <input type="submit" value="Update product" class="button"/>
            </form>
        </c:if>
        </p>
    </body>
</html>