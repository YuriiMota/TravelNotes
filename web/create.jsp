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
    <title>Create Notes</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="stylesCreate.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <form action="/create" method="post">
        <div class="row">
            <div class="col-25">
                <label for="fname">Title</label>
            </div>
            <div class="col-75">
                <input type="text" id="fname" name="title" placeholder="Write your title..">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="lname">Country</label>
            </div>
            <div class="col-75">
                <input type="text" id="lname" name="country" placeholder="Write your country">
            </div>
        </div>
        <input type="hidden"  name="image" value="${uploadImage}" >
        <div class="row">
            <div class="col-25">
                <label for="descr">Description</label>
            </div>
            <div class="col-75">
                <textarea id="descr" name="description" placeholder="Write something.." style="height:200px"></textarea>
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
<div>
    <form action="/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="image"/>${message}
        <input type="submit" value="upload"/>

    </form>
    <img src="${uploadImage}" name="image" alt="Your pic" style="width:300px;height:200px;">
</div>


</body>
</html>
