<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>My Travel Notes</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="styles.css" rel="stylesheet">
</head>
<body>


<div class="container">
    <h1>Your own page</h1>

    <a href='<c:url value="/editname?id=${userName.getId()}" />'>
        <p>
            <c:out value="${userName.getFirstName()} "></c:out>
            <c:out value="${userName.getLastName()}"></c:out>
        </p>
    </a>
    <hr>
    <div class="col-25">
        <div class="row">
            <button onclick="location.href = '/create.jsp';">Add New Story</button>
        </div>


        <c:forEach var="place" items="${places}">
            <a href='<c:url value="/view?id=${place.getId()}" />'>
                <p><c:out value="${place.getTitle()}"/></p>
            </a>
            <p><c:out value="${place.getDescription()}"/></p>

            <p>
                <img src="${place.getImage()}" alt="Your pic" style="width:300px;height:200px;">
            </p>
        </c:forEach>
        <%--<div class="row">
            <button onclick="location.href = '/update.jsp';">Update</button>
        </div>
        <div class="row">
            <button onclick="location.href = '/delete.jsp';">Delete</button>
        </div>--%>
    </div>
</div>

</body>
</html>
