<%-- 
    Document   : index
    Created on : Oct 13, 2016, 12:14:56 PM
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
        <h1>Login DEMO </h1>
        <form method="get" action="login">        
            Username :<input type="text" name="username" /><br/><br/>
            Password :<input type="password" name="password" /><br/><br/>
            <input type="submit" value="Login" />
            <button><a href="signup.jsp">SIGNUP</a></button>
        </form>
       
    </body>
</html>
