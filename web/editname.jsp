<%--
  Created by IntelliJ IDEA.
  User: Yura
  Date: 15.03.2019
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Name</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="stylesCreate.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <form action="/editname" method="post">
        <input type="hidden" value="${user.getId()}" name="id" >

        <div class="row">
            <div class="col-25">
                <label for="fname">First Name</label>
            </div>
            <div class="col-75">
                <input type="text"  value="${user.getFirstName()}" id="fname" name="fname" placeholder="Last Name">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="lname">Last Name</label>
            </div>
            <div class="col-75">
                <input type="text" value="${user.getLastName()}" id="lname" name="lname" placeholder="First Name">
            </div>
        </div>


        <div class="row">
            <input type="submit" value="Submit">
        </div>

    </form>
</div>
<div class="row">
    <button onclick="location.href = '/mynotes';">Cancel</button>
</div>
</body>
</html>
