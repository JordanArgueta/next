<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to NEXT</title>
    <style>
    body {padding-bottom: 50px}

    .slider-holder
    {
        width: 800px;
        height: 400px;
        background-color: yellow;
        margin-left: auto;
        margin-right: auto;
        margin-top: 0px;
        text-align: center;
        overflow: hidden;
    }

    .image-holder
    {
        width: 2400px;
        background-color: red;
        height: 400px;
        clear: both;
        position: relative;

        -webkit-transition: left 2s;
        -moz-transition: left 2s;
        -o-transition: left 2s;
        transition: left 2s;
    }

    .slider-image
    {
        float: left;
        margin: 0px;
        padding: 0px;
        position: relative;
    }

    #slider-image-1:target ~ .image-holder
    {
        left: 0px;
    }

    #slider-image-2:target ~ .image-holder
    {
        left: -800px;
    }

    #slider-image-3:target ~ .image-holder
    {
        left: -1600px;
    }

    .button-holder
    {
        position: relative;
        top: -20px;
    }

    .slider-change
    {
        display: inline-block;
        height: 10px;
        width: 10px;
        border-radius: 5px;
        background-color: brown;
    }
</style>
</head>
<body>
<h1>Welcome, What Will You Do NEXT?</h1>
<h3>Hello <UIHelper:memberName/>!</h3>
<h3>Welcome to our volunteering website!</h3>

<div class="slider-holder" style="padding-bottom: 50px">
    <span id="slider-image-1"></span>
    <span id="slider-image-2"></span>
    <span id="slider-image-3"></span>
    <div class="image-holder">
        <g:img dir="images" file="volunteer.jpg" style="width:800px; height:400px;" class="slider-image"></g:img>
        <g:img dir="images" file="volunteer1.jpg" style="width:800px; height:400px;" class="slider-image"></g:img>
        <g:img dir="images" file="volunteer2.png" style="width:800px; height:400px;" class="slider-image"></g:img>
    </div>
    <div class="button-holder">
        <a href="#slider-image-1" class="slider-change"></a>
        <a href="#slider-image-2" class="slider-change"></a>
        <a href="#slider-image-3" class="slider-change"></a>
    </div>
</div>

<h3>By this point you have already created a User Profile! What this means is that you can register for events or even
plan your own!</h3>

<h3> After you are signed in, you can find events to sign up for on the left navigation pane! There, you can click on
the event that you would like to register for! You will then see a page of all of your registered events!</h3>


</body>

</html>