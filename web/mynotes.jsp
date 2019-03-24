<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>My Notes</title>
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
<div class="container"><img src="assets/img/50GwXvXkZpk.jpg" style="width: 1140px;height: 164px;"></div>
<div>
    <nav class="navbar navbar-default navigation-clean-button">
        <div class="container">
            <div class="navbar-header"><a class="navbar-brand"
                                          href='<c:url value="/editname?id=${userName.getId()}" />'>
                <p>
                    <c:out value="${userName.getFirstName()} "></c:out>
                    <c:out value="${userName.getLastName()}"></c:out>
                </p></a>
                <button class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navcol-1"><span
                        class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span
                        class="icon-bar"></span><span class="icon-bar"></span></button>
            </div>
            <div
                    class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav">

                    <li role="presentation"><a href="/create.jsp"
                                               style="font-size: 18px;font-family: Bitter, serif;color: rgb(52,64,74);">Add new Story</a></li>
                </ul>
                <p class="navbar-text navbar-right actions"><a class="btn btn-default action-button" role="button"
                                                               href="/logOff">Log out</a></p>
            </div>
        </div>
    </nav>
</div>
<div class="projects-horizontal">
    <div class="container">

        <div class="row projects">
            <div class="col-sm-12">
                <c:forEach var="place" items="${places}">
                    <div class="col-sm-6 item">
                        <div class="row">

                            <div class="col-md-5"><a href="<c:url value="/view?id=${place.getId()}" />">
                                <img
                                        class="img-responsive" src="${place.getImage()}"></a></div>
                            <div class="col-md-7">
                                <h3 class="name"><c:out value="${place.getTitle()}"/></h3>

                                <p class="description"><c:out value="${fn:substring(place.getDescription(),0,170)}"/><a
                                        href="<c:url value="/view?id=${place.getId()}" />">...read more</a></p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>

<div class="article-list"></div>
<div class="footer-dark">
    <footer>
        <div class="container">
            <p class="copyright">Mota Yurii © 2019</p>
        </div>
    </footer>
</div>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>