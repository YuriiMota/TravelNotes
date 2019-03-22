<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Create Notes</title>

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
<%--    <script src="jquery-1.8.2.js"></script>
    <script src="jquery.ajaxfileupload.js"></script>
    <script language="Javascript">
        $(document).ready(function(){
            $('input[type="file"]').ajaxfileupload({
                'action': 'create',
                'onComplete': function(response) {
                    $('#upload').hide();
                    alert("File SAVED!!");
                },
                'onStart': function() {
                    $('#upload').show();
                }
            });
        });
    </script>--%>
</head>

<body style="height: 673px;background-image: url(assets/img/fog-foggy-forest-4765.jpg);">
    <div class="container" style="height: 412px;color: rgb(207,207,207);width: 911px;padding: 12px;">
        <h1></h1>
        <header></header>
        <header></header>
<form action="/create" method="post"  enctype="multipart/form-data">
    <input type="hidden"  name="id">
        <h1 style="font-size: 37px;color: white;font-family: Bitter, serif;">Create Your Story</h1>
        <h1 style="color: rgb(228,228,228);font-family: Bitter, serif;font-size: 15px;">Title</h1><input name="title" type="text" style="height: 36px;width: 531px;color: rgb(0,0,0);opacity: 0.71;">
        <header></header>
    <input type="hidden"  name="image" value="${uploadImage}" >
        <h1 style="font-size: 14px;color: rgb(255,255,255);">Country</h1><input name="country" type="text" style="height: 36px;width: 531px;color: rgb(0,0,0);opacity: 0.75;">
        <h1 style="font-size: 14px;color: rgb(231,231,231);">Description</h1><textarea name="description" style="color: rgb(17,16,16);width: 835px;height: 182px;opacity: 0.82;"></textarea>
    <input type="file" name="file" />
    <div class="container" style="padding: 10px;"><button class="btn btn-default" type="Submit" value="Submit" style="height: 48px;padding: 10px;margin: 39px;background-color: rgb(82,129,176);font-size: 15px;color: rgb(255,255,255);opacity: 0.82;width: 181px;font-family: Bitter, serif;">Submit</button>
        <button class="btn btn-default"
                type="button" onclick="location.href = '/mynotes';" style="height: 48px;padding: 10px;margin: 39px;background-color: rgb(207,4,4);font-size: 15px;color: rgb(255,250,250);opacity: 0.82;width: 181px;font-family: Bitter, serif;">cancel</button></div>
    </form>
       <%-- <form action="/upload" method="post" enctype="multipart/form-data">
            <input type="file" name="image"/>${message}
            <input class="btn btn-default" type="submit" value="upload"  />
        </form>--%>
<%--        <div class="centered">

            <input type="file" name="datafile" /><br/>
            <div id="upload" style="display:none;">Uploading..</div>
        </div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    </div>--%>

</body>

</html>