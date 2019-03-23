<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>View Note</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,400italic">
    <link rel="stylesheet" href="assets/fonts/ionicons.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Bitter:400,700">
    <link rel="stylesheet" href="assets/css/user.css">
    <link rel="stylesheet" href="assets/css/Article-List.css">
    <link rel="stylesheet" href="assets/css/Footer-Basic.css">
    <link rel="stylesheet" href="assets/css/Footer-Dark.css">
    <link rel="stylesheet" href="assets/css/Header-Dark.css">
    <link rel="stylesheet" href="assets/css/Login-Form-Dark.css">
    <link rel="stylesheet" href="assets/css/Navigation-with-Button.css">
    <link rel="stylesheet" href="assets/css/Projects-Horizontal.css">
    <link rel="stylesheet" href="assets/css/Registration-Form-with-Photo.css">
</head>

<body style="height: 673px;">
<div class="container"><img src="assets/img/50GwXvXkZpk.jpg" style="width: 1139px;height: 164px;"></div>
<div class="container" style="height: 84px;text-align:center;">
    <form action="/delete" method="post">
        <button onclick="location.href = '/mynotes';" class="btn btn-default " type="button"
                style="height: 48px;padding: 10px;margin: 39px;background-color: rgb(26,104,183);font-size: 15px;color: rgb(255,255,255);opacity: 0.82;width: 181px;font-family: Bitter, serif;">
            My Notes
        </button>
        <button onclick="location.href = '/edit?id=${place.getId()}';"
                class="btn btn-default" type="button"
                style="height: 48px;padding: 10px;margin: 39px;background-color: rgb(4,152,10);font-size: 15px;color: rgb(255,255,255);opacity: 0.82;width: 181px;font-family: Bitter, serif;">
            Edit
        </button>

        <input type="hidden" name="id" value="${place.getId()}">
        <button class="btn btn-default" type="submit" value="Delete"
                style="height: 48px;padding: 10px;margin: 39px;background-color: rgb(207,4,4);font-size: 15px;color: rgb(255,250,250);opacity: 0.82;width: 181px;font-family: Bitter, serif;">
            Delete
        </button>
    </form>

</div>

<div
        class="container" style="height: 412px;color: rgb(207,207,207);width: 911px;padding: 12px;">
    <p>
    <h1><c:out value="${place.getTitle()}"/></h1></p>
    <p style="text-align: center; float: right ;margin: 20px">
        <img src="${place.getImage()}" alt="Your pic" style="width:450px;height:280px; ">
    </p>
    <p>
    <h3><c:out value="${place.getCountry()}"/></h3></p>
    <p><h4 style="line-height: 30px; text-indent: 20px; text-align: justify; ">
    <c:out value="${place.getDescription()}"/></h4>
    </p>


    <header></header>
</div>

<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>

</body>

</html>