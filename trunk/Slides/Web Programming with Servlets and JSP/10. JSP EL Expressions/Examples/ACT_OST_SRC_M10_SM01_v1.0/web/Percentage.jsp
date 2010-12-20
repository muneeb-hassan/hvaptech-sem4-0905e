<%--Percentage.jsp
*
* This program demonstrates the use of Expression language implicit objects
*
* Copyright © 2007 Aptech Software Limited. All rights reserved.
--%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC “-//W3C//DTD HTML 4.01 Transitional//EN”
“http://www.w3.org/TR/html4/loose.dtd”>
<%--  
 * @ author vincent
 --%>
<html>
    <head>
        <title>
            Percentage
        </title>
    </head>
    <body bgcolor="#ffffff">
        <h1>
            Percentage of Marks
        </h1>
        <form action="Percentage.jsp">
            <table>
                <tr>
                    <td>Enter marks for English:</td><td><input
                    type="text" value="${param.english}" name="english" size="5" 
                    maxlength="2"/> <b>/100 </b></td>
                </tr>
                <tr>
                    <td>Enter marks for Science:</td><td><input type="text" 
                    value="${param.science}" name="science" size="5" maxlength="2"/> <b>/100 </b></td>
                </tr>
                <tr>
                    <td>Enter marks for History:</td><td><input
                    type="text" value="${param.history}" name="history" size="5" 
                    maxlength="2"/> <b>/100 </b></td>
                </tr>
                <tr>
                    <td>Enter marks for Geography:</td><td><input 
                    type="text" value="${param.geography}" name="geography" 
                    size="5" maxlength="2"/> <b>/100 </b></td>
                </tr>
                <tr>
                    <td>Enter marks for Maths:</td><td><input type="text" 
                     value="${param.maths}" name="maths" size="5" maxlength=”2”/> <b>/100 </b></td>
                </tr>
                <tr>
                    <td>Total:</td><td>${param.english + param.science + param.history + param.geography + param.maths} out of 500</td>
                </tr>
                <tr>
                    <td>%age :</td><td>${(param.english + param.science + param.history + param.geography + param.maths)/500 *100}</td>
                </tr>
                <tr>
                    <td></td><td><input type=submit></td>
                </tr>
            </table>
        </form>
    </body>
</html>