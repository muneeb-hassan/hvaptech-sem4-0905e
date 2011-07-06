<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alluring Decors</title>
<link rel="stylesheet" type="text/css" href="CSS/default.css" />
<link rel="stylesheet" type="text/css" href="CSS/index.css" />
<script type="text/javascript" src="Scripts/jquery-1.5.1.js"></script>
<script type="text/javascript" src="Scripts/dropdowntabs.js"></script>
</head>
<body>

<div id="wrapper">
  	<jsp:include page="header.jsp" />     

	<div id="menu">
    	<ul>
        	<li><a href="index.jsp" class="selected">Home</a></li>
            <li><a href="about.jsp">About us</a></li>
            <li><a href="projects.jsp">Projects</a></li>
            <li><a href="services.jsp">Services</a></li>
            <li><a href="contact.jsp">Contact us</a></li>
            <li><a href="feedback.jsp">Feedback</a></li>
            <li><a href="faq.jsp">FAQs</a></li>
		<%
    		if(session.getAttribute("userrole") != null){
    			if(session.getAttribute("userrole").toString().equals("1")){out.print("<li><a href=\"#\" class=\"selected\" rel=\"menu_order\">Order</a></li>");}
    			if(session.getAttribute("userrole").toString().equals("2")){out.print("<li><a href=\"#\" class=\"selected\" rel=\"menu_admin\">Admin</a></li>");}
			}
		%>
        </ul>
    </div>
    <%
    	if(session.getAttribute("userrole") != null){
    		if(session.getAttribute("userrole").toString().equals("2")){
    			out.println("<div id=\"menu_admin\" class=\"admintabs\">");
    			out.println("<a href=\"feedback_admin02.jsp\"> Manage Feedback</a>");
    			out.println("<a href=\"contact_admin02.jsp\">Manage Contact</a>");
    			out.println("<a href=\"contact_admin01.jsp\">Add new Contact</a>");
    			out.println("<a href=\"domain_admin.jsp\">Manage Domain</a>");
    			out.println("<a href=\"faq_admin02.jsp\">Manage FAQ</a>");
    			out.println("<a href=\"faq_admin01.jsp\">Add new FAQ</a>");
    			out.println("<a href=\"projects_admin02.jsp\">Manage Projects</a>");
    			out.println("<a href=\"projects_admin01.jsp\">Add new Project</a>");
    			out.println("<a href=\"services_admin.jsp\">Manage Services</a>");
    			out.println("<a href=\"user_admin02.jsp\">Manage User</a>");
    			out.println("<a href=\"admin_order_management.jsp\">Manage Order</a>");    
    			out.println("</div>");  
    			out.println("<script type=\"text/javascript\">");
    			out.println("tabdropdown.init(\"menu\", 0)");
    			out.println("</script>");
    		}else{
    			out.println("<div id=\"menu_order\" class=\"usertabs\">");
    			out.println("<a href=\"userorder.jsp\">Order Service</a>");
    			out.println("<a href=\"user_order_management.jsp\">Manage Contact</a>");
    			out.println("</div>");  
    			out.println("<script type=\"text/javascript\">");
    			out.println("tabdropdown.init(\"menu\", 0)");
    			out.println("</script>");			
			}
    	}
	%>
    <div id="content">
    	<div id="main_01">
		<div id="content_top">
			<div class="content_top_01">
				<div class="content_top_01A"><img src="Images/Content_top.jpg" /></div>
                <div class="content_top_01B">
                    Designs, colors, paints, trends -- you name it, we've got it. Learn the basics of decorating or search 
                    room by room or ideas to decorate your home or your business. 
                </div>
          	</div>
            <div class="content_top_02" id="bigPic">
				<img src="Images/Home/1000 Living Rooms.jpg" alt="" />
				<img src="Images/Home/Bathrooms Double.jpg" alt="" />
				<img src="Images/Home/Bathrooms two Sink.jpg" alt="" />
				<img src="Images/Home/Ceilings.jpg" alt="" />
				<img src="Images/Home/Contemporary.jpg" alt="" />
				<img src="Images/Home/Elegant Dining.jpg" alt="" />
				<img src="Images/Home/Fashionable Modern Kitchens.jpg" alt="" />
				<img src="Images/Home/Landscaping.jpg" alt="" />
				<img src="Images/Home/Every Style for Every Budget.jpg" alt="" />
				<img src="Images/Home/Fireplace Wall.jpg" alt="" />                
            </div>
		</div>

      <div id="content_top_right">
        <div class="content_top_right_01">Top Product Decorating</div>
            <ul id="thumbs">
				<li class='active' rel='1'><img src="Images/Home/1000 Living Rooms_thumb.jpg" alt="" /></li>
				<li rel='2'><img src="Images/Home/Bathrooms Double_thumb.jpg" alt="" /></li>
				<li rel='3'><img src="Images/Home/Bathrooms two Sink_thumb.jpg" alt="" /></li>
				<li rel='4'><img src="Images/Home/Ceilings_thumb.jpg" alt="" /></li>
				<li rel='5'><img src="Images/Home/Contemporary_thumb.jpg" alt="" /></li>
				<li rel='6'><img src="Images/Home/Elegant Dining_thumb.jpg" alt="" /></li>
				<li rel='7'><img src="Images/Home/Fashionable Modern Kitchens_thumb.jpg" alt="" /></li>
			  	<li rel='8'><img src="Images/Home/Landscaping_thumb.jpg" alt="" /></li>
				<li rel='9'><img src="Images/Home/Every Style for Every Budget_thumb.jpg" alt="" /></li>
			  	<li rel='10'><img src="Images/Home/Fireplace Wall_thumb.jpg" alt="" /></li>
            </ul>
        </div>
        
	<script type="text/javascript">
	var currentImage;
    var currentIndex = -1;
    var interval;
    function showImage(index){
        if(index < $('#bigPic img').length){
        	var indexImage = $('#bigPic img')[index]
            if(currentImage){   
            	if(currentImage != indexImage ){
                    $(currentImage).css('z-index',2);
                    clearTimeout(myTimer);
                    $(currentImage).fadeOut(250, function() {
					    myTimer = setTimeout("showNext()", 3000);
					    $(this).css({'display':'none','z-index':1})
					});
                }
            }
            $(indexImage).css({'display':'block', 'opacity':1});
            currentImage = indexImage;
            currentIndex = index;
            $('#thumbs li').removeClass('active');
            $($('#thumbs li')[index]).addClass('active');
        }
    }
    
    function showNext(){
        var len = $('#bigPic img').length;
        var next = currentIndex < (len-1) ? currentIndex + 1 : 0;
        showImage(next);
    }
    
    var myTimer;
    
    $(document).ready(function() {
	    myTimer = setTimeout("showNext()", 3000);
		showNext(); //loads first image
        $('#thumbs li').bind('click',function(e){
        	var count = $(this).attr('rel');
        	showImage(parseInt(count)-1);
        });
	});
   
	</script>
    </div>
    <div id="main_01" style="margin-bottom:30px;">
    	<div class="border_top"></div>
        <div class="domain_wrapper">
        	<div class="domain_01_left">
        		<div class="domain_01" style="margin-bottom:10px; margin-top:10px;"><img src="Images/Domain.jpg"></div>
        		<div class="domain_01" id="domain_01_top">
        			<div class="setimage">
            			<a href="projects.jsp" class="showimage">
        				<img src="Images/Home1/House 008_thumb.jpg">Decorating the House
            			<span><img src="Images/Home1/House 008.jpg"></span>
            			</a>
          			</div>
            		<div class="setimage">
            			<a href="projects.jsp" class="showimage">
            			<img src="Images/Home1/Office_thumb.jpg">Decorating the Office
            			<span><img src="Images/Home1/Office.jpg"></span>
            			</a>
      				</div>
            		<div class="setimage">
            			<a href="projects.jsp" class="showimage">
            			<img src="Images/Home1/Restaurant_thumb.jpg">Decorating the Restaurant
            			<span><img src="Images/Home1/Restaurant.jpg"></span>
            			</a>
    				</div>
            		<div class="setimage">
            			<a href="projects.jsp" class="showimage">
            			<img src="Images/Home1/Wedding_thumb.jpg">Decorating the Community Hall
            			<span><img src="Images/Home1/Wedding.jpg"></span>
            			</a>
          			</div>
        		</div>
            </div>
        	<div class="domain_01_right">Domain introduction</div>
        </div>
      
    	<div class="border_top"></div>
        <div class="domain_wrapper" style="margin-bottom:50px;">
        	<div class="domain_01_left">
        		<div class="domain_01" style="margin-bottom:10px; margin-top:10px;"><img src="Images/Service.jpg"></div>
        		<div class="domain_01" id="domain_01_top">
        			<div class="setimage">
            			<a href="projects.jsp" class="showimage">
        				<img src="Images/Home1/Colour_thumb.jpg">Colour Schemes
            			<span><img src="Images/Home1/Colour.jpg"></span>
            			</a>
          			</div>
            		<div class="setimage">
            			<a href="projects.jsp" class="showimage">
            			<img src="Images/Home1/Lighting_thumb.jpg">Lightning Effects
            			<span><img src="Images/Home1/Lighting.jpg"></span>
            			</a>
      				</div>
            		<div class="setimage">
            			<a href="projects.jsp" class="showimage">
            			<img src="Images/Home1/Window_Corver_thumb.jpg">Window Coverings
            			<span><img src="Images/Home1/Window_Corver.jpg"></span>
            			</a>
    				</div>
            		<div class="setimage">
            			<a href="projects.jsp" class="showimage">
            			<img src="Images/Home1/kitchen_thumb.jpg">Decorating the Community Hall
            			<span><img src="Images/Home1/kitchen.jpg"></span>
            			</a>
          			</div>
        		</div>
            </div>
        	<div class="domain_01_right">Services introduction</div>
        </div>
        
    </div>	        
	</div>
		
	<jsp:include page="footer.jsp" />

</div>
</body>
</html>