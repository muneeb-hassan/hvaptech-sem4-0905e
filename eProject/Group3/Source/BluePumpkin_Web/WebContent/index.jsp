<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-gb" lang="en-gb" >
<head>
  <meta http-equiv="content-type" content="text/html; charset=utf-8" />
  <title>Blue Pumpkin</title>
  <link href="" rel="shortcut icon" type="image/x-icon" />
  <link rel="stylesheet" href="CSS/template.css" type="text/css" />
<!--[if lte IE 6]>
<link href="CSS/ie6.css" rel="stylesheet" type="text/css" />
<![endif]-->
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
							<jsp:include page="search.jsp"></jsp:include>
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
								<jsp:include page="content.jsp"></jsp:include>
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
