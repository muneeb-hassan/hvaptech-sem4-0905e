<!DOCTYPE HTML PUBLIC ?-//W3C//DTD HTML 4.0 Transitional//EN?>
<HTML>
    <HEAD>
        <TITLE>Using the Debug Tag</TITLE>
        <%request.setAttribute("debug","false");%>
    </HEAD>
    <BODY>
        <H1>Using the Debug Tag</H1>
        <%@ taglib uri="/WEB-INF/tlds/DebugTags" prefix="d" %>
        Top of regular page.<hr />
        <d:DebugTags>
            <B>Debug:</B>
            <UL>
                <LI>Current time: <%= new java.util.Date() %>
                <LI>Requesting hostname: <%= request.getRemoteHost() %>
                <LI>Session ID: <%= session.getId() %>
            </UL>
        </d:DebugTags>
        <h1>Page Body</h1>
        <hr />
        Bottom of regular page.
    </BODY>
</HTML>