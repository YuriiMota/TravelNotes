<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Edit Name</title>
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

<body>
<div>
    <div class="header-dark" style="height: 630px;">
        <nav class="navbar navbar-default navigation-clean-search" style="height: 24px;">
            <div class="container">
                <div class="navbar-header"><a class="navbar-brand" href="/mynotes">Your Travel Stories</a>
                    <button class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navcol-1"><span
                            class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span
                            class="icon-bar"></span><span class="icon-bar"></span></button>
                </div>
                <div
                        class="collapse navbar-collapse" id="navcol-1">
                    <form class="navbar-form navbar-left" target="_self">
                        <div class="form-group"><label class="control-label"></label></div>
                        <ul class="nav navbar-nav"></ul>
                    </form>
                    <p class="navbar-text navbar-right"><a class="btn btn-default action-button" role="button"
                                                           href="/logOff">Log out</a></p>
                </div>
            </div>
        </nav>
        <form action="/editname" method="post">
            <div class="container hero">
                <div class="row" style="height: 481px;">
                    <div class="col-md-8 col-md-offset-2" style="height: 429px;">
                        <input type="hidden" value="${user.getId()}" name="id">
                        <h1 class="text-center">Edit Name</h1>
                        <h1 style="margin: 24px;height: 42px;width: 736px;">First Name</h1><input type="text"
                        value="${user.getFirstName()}"
                        name="fname" style="width: 239px;height: 37px;margin: -1px;">
                        <h1 style="margin: 14px;height: 42px;width: 736px;">Last Name</h1>
                        <input type="text"
                         value="${user.getLastName()}"
                         name="lname"
                         style="width: 239px;height: 37px;padding: 0px;">
                        <button class="btn btn-default" type="Submit"
                                style="margin: 24px;height: 37px;width: 69px;background-color: rgb(4,179,0);color: rgb(234,234,234);">
                            Save
                        </button>
                        <button
                                class="btn btn-default" type="button" onclick="location.href = '/mynotes';"
                                style="margin: 24px;background-color: rgb(235,71,71);color: rgb(235,235,235);">Cancel
                        </button>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>