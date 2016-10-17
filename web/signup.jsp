<%-- 
    Document   : signup
    Created on : Oct 13, 2016, 7:00:40 PM
    Author     : abhinav.kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>SIGNUP DEMO</h1>
        <form method="get" action="signup">        
            Username :<input type="text" name="username" /><br/><br/>
            Password :<input type="password" name="password" /><br/><br/>
            Address :<textarea  name="address"></textarea><br/><br/>
            Mobile :<input type="text" name="phone" /><br/><br/>            
            <input type="submit" value="Register" />
        </form>
    </body>
</html>
