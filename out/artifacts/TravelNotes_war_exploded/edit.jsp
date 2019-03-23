<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Edit Notes</title>
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
    <link rel="stylesheet" href="assets/css/Registration-Form-wth-Photo.css">
</head>

<body style="height: 673px;background-image: url(assets/img/myths-and-mountains-nepal.jpg);">
<form action="/edit" method="post"  enctype="multipart/form-data">
    <div class="container" style="height: 412px;color: rgb(207,207,207);width: 911px;padding: 12px;">
        <header></header>
        <h1></h1>
        <div class="page-header">
            <h1 style="color: rgb(59,49,170);">Edit your trip</h1>

        </div>
        <img  style="float:right;width:280px;height:180px;"src="${place.getImage()}" alt="Your pic" style="width:300px;height:200px;">

        <h1 style="font-size: 12px;">Title</h1>

        <header></header>
        <input type="hidden" value="${place.getId()}" name="id">
        <input type="hidden"  name="image" value="${place.getImage()}" >

        <input type="text" style="height: 36px;width: 531px;color: rgb(72,70,70);"value="${place.getTitle()}"  name="title" placeholder="Write your title..">
        <h1 style="font-size: 14px;">Country</h1><input type="text" value="${place.getCountry()}"  name="country"
                                                        placeholder="Write your country"
                                                        style="height: 36px;width: 531px;color: rgb(72,70,70);">

        <h1 style="font-size: 14px;">Description</h1><textarea name="description" placeholder="Write something.."
            style="color: rgb(17,16,16);width: 835px;height: 182px;">${place.getDescription()}</textarea>
       <div><input  type="file" name="file" /></div>
    </div>

    <div class="container" style="padding: 80px;">

        <button  class="btn btn-default" type="submit"
                style="height: 48px;padding: 10px;margin: 39px;background-color: rgb(26,104,183);font-size: 15px;color: rgb(255,255,255);opacity: 0.82;width: 181px;font-family: Bitter, serif;">
            Submit
        </button>
        <button class="btn btn-default"
                type="button" onclick="location.href = '/view?id=${place.getId()}';"
                style="height: 48px;padding: 10px;margin: 39px;background-color: rgb(207,4,4);font-size: 15px;color: rgb(255,250,250);opacity: 0.82;width: 181px;font-family: Bitter, serif;">
            cancel
        </button>
    </div>
</form>

<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>