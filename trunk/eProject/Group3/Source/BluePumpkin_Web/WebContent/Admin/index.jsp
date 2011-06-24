<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Blue Pumpkin</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" type="text/css" href="../CSS/template_admin.css" />  
    <script type="text/javascript" src="../JS/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            var $navLi = $('#wrapper #nav li'); 
        $('<span></span>').insertBefore('#wrapper #nav li a');
        
        $navLi.each(function() {
           var linkText = $(this).find('a').text();
           $(this).find('span').show().text(linkText);
           //alert(linkText);
        });
        $navLi.hover(function() {
            $(this)
            .find('span')
            .stop()
            .animate({marginTop: '-40px'}, 300);
        }, function() {
            $(this)
            .find('span')
            .stop()
            .animate({marginTop: '0px'}, 300);
        });
        });
     </script>
</head>
<body>
    <div id="header">
        <jsp:include page="/Admin/header.jsp"></jsp:include>
    </div>
    
    <div id="content">

    </div>
    
    <div id="footer">
        Copyright© 2010 By <a>Flower Store</a>, All Rights Reserved.
    </div>
   
</body>
</html>