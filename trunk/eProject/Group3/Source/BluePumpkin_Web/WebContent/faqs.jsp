<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-gb" lang="en-gb" >
	<head>
  		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
  		<title>Blue Pumpkin</title>
  		<link href="" rel="shortcut icon" type="image/x-icon" />
  		<link rel="stylesheet" href="CSS/template.css" type="text/css" />
		<link rel="stylesheet" href="CSS/jquery.css" type="text/css" />
  		<script type="text/javascript" src="JS/jquery.min.js"></script>
  		<script type="text/javascript">
	        $(document).ready(function() {
	            $('#wrapper p:not(:first)').hide();
	            $('#wrapper h1:first').addClass('active');
	            $('#wrapper h1').click(function() {
	                $('.active').removeClass('active');
	                $('#wrapper p').slideUp('normal');
	                if($(this).next('#wrapper p').is(':hidden') == true) {
	                $(this).addClass('active');
	                $(this).next('#wrapper p').slideDown('normal');
	                }
	            });
	            $('#wrapper h1').hover(function(){//over
	                $(this).addClass('on');
	            },function() {//out
	                $(this).removeClass('on');
	            });
	        });
	     </script>
	</head>
<body id="page_bg">
	<div id="bg">
		<div id="top_bg">
			<div id="footer_bg">
				<div id="container">
					<div id="top">
						<div id="pillmenu">
							<jsp:include page="menu.jsp"></jsp:include>
						</div>
						
						<div id="search">
							<form action="index.php" method="post">
								<div class="search">
									<input name="searchword" id="mod_search_searchword" maxlength="20" alt="Search" class="inputbox" type="text" size="20" value="search..."  onblur="if(this.value=='') this.value='search...';" onfocus="if(this.value=='search...') this.value='';" /><input type="submit" value="Search" class="button" onclick="this.form.searchword.focus();"/>	</div>
								<input type="hidden" name="task"   value="search" />
								<input type="hidden" name="option" value="com_search" />
								<input type="hidden" name="Itemid" value="1" />
							</form>
						</div>
						<div class="clr"></div>
					</div>
						<jsp:include page="header.jsp"></jsp:include>
						
					<div id="content_bottom">
						<div id="content">
							<div id="leftcolumn">
								<jsp:include page="leftColumn.jsp"></jsp:include>
							</div>
							<div id="maincolumn">	
							<div id="wrapper">
							        <h1>How to participate in the events?</h1>
							        <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. 
							        Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero 
							        sit amet quam egestas semper. Aenean ultricies mi vitae est. Ut felis. Praesent dapibus, neque 
							        id cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat 
							        volutpat. Nam dui mi, tincidunt quis, accumsan porttitor, facilisis luctus, metus
							        </p>
							        <h1>What if I am unable to login into the site?</h1>
							        <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. 
							        Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero 
							        sit amet quam egestas semper. Aenean ultricies mi vitae est. Ut felis. Praesent dapibus, neque 
							        id cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat 
							        volutpat. Nam dui mi, tincidunt quis, accumsan porttitor, facilisis luctus, metus
							        </p>
							        <h1>What if I am unable to send the participation request for the event?</h1>
							        <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. 
							        Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero 
							        sit amet quam egestas semper. Aenean ultricies mi vitae est. Ut felis. Praesent dapibus, neque 
							        id cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat 
							        volutpat. Nam dui mi, tincidunt quis, accumsan porttitor, facilisis luctus, metus
							        </p>
							        <h1>How can one be intimated with the upcoming events</h1>
							        <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. 
							        Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero 
							        sit amet quam egestas semper. Aenean ultricies mi vitae est. Ut felis. Praesent dapibus, neque 
							        id cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat 
							        volutpat. Nam dui mi, tincidunt quis, accumsan porttitor, facilisis luctus, metus
							        </p>
							    </div>
							    </div>
							<div id="rightcolumn">
								<jsp:include page="rightColumn.jsp"></jsp:include>
							</div>
							<div class="clr"></div>
								<div id="footer">
									<jsp:include page="footer.jsp"></jsp:include>
								</div>
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>		
</html>