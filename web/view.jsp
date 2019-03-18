<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>


<p><c:out value="${place.getTitle()}"/></p>
<p><c:out value="${place.getCountry()}"/></p>
<p><c:out value="${place.getDescription()}"/></p>


<p>
    <img src="${place.getImage()}" alt="Your pic" style="width:300px;height:200px;">
</p>
<div class="row">
    <button onclick="location.href = '/edit?id=${place.getId()}';">Edit</button>
    <button onclick="location.href = '/mynotes';">Return to My Notes</button>
    <div>
        <br>
        <form action="/delete" method="post">
            <input type="hidden" name="id" value="${place.getId()}">
            <input type="submit" value="Delete">

        </form>
    </div>
</div>


</body>
</html>
