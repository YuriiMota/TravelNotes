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
    <title>Edit Notes</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="stylesCreate.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <form action="/edit" method="post">
        <input type="hidden" value="${place.getId()}" name="id">

        <div class="row">
            <div class="col-25">
                <label for="fname">Title</label>
            </div>
            <div class="col-75">
                <input type="text" value="${place.getTitle()}" id="fname" name="title" placeholder="Write your title..">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="lname">Country</label>
            </div>
            <div class="col-75">
                <input type="text" value="${place.getCountry()}" id="lname" name="country"
                       placeholder="Write your country">
            </div>
        </div>

        <div class="row">
            <div class="col-25">
                <label for="descr">Description</label>
            </div>
            <div class="col-75">
                <textarea id="descr" name="description" placeholder="Write something.."
                          style="height:200px">${place.getDescription()}</textarea>
            </div>
        </div>

        <div class="row">
            <input type="submit" value="Submit">
        </div>

    </form>
</div>


<p>
    <img src="${place.getImage()}" alt="Your pic" style="width:300px;height:200px;">

</p>
</form>
<div class="row">
    <button onclick="location.href = '/mynotes';">Cancel</button>
</div>
</body>
</html>
