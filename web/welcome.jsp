<%-- 
    Document   : welcome
    Created on : Oct 13, 2016, 6:51:08 PM
    Author     : abhinav.kumar
--%>

<%@page import="com.aurionpro.login.FetchUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ page import="com.aurionpro.login.User" %>
        <%@ page import="java.util.*" %> 
        <%@ page import="java.io.*" %> 
        <h1>Welcome.............</h1>
        <table>
            <%
                String username = request.getParameter("username");
                String address = request.getParameter("address");
                String phone = request.getParameter("phone");
                String id = request.getParameter("id");
            %>
            <form method="get" action="update">   
                <input type="hidden" name="id" value="<%=id%>"/>
                Username :<input type="text" name="username" value="<%=username%>" /><br/><br/>
                Address :<textarea  name="address" value=""><%=address%></textarea><br/><br/>
                Mobile :<input type="text" name="phone" value="<%=phone%>"/><br/><br/>
                
                <input type="submit" value="Submit" />            
            </form>
        </table>
                <br>
        <table>
            <tr>
                <th>UserName</th>
                <th>Address</th>
                <th>Phone</th>
                <th>Action</th>
            </tr>
            <%
                ArrayList<User> users = FetchUser.users();
                Iterator it = users.iterator();
                while (it.hasNext()) {
                    User b = (User) it.next();
            %>
            <tr>
                <td><%=b.getUserName()%></td>
                <td><%=b.getAddress()%></td>
                <td><%=b.getPhone()%></td>                
                <td><a href=<%= "welcome.jsp?id=" + b.getId() + "&username=" + b.getUserName() + "&address=" + b.getAddress() + "&phone=" +b.getPhone()%>>UPDATE</a></td>
                <td><a href=<%= "delete?id=" + b.getId()%> >DELETE</a></td>
            </tr>
            <%
                }
            %>
        </table>
        <br>
        <div><a href="index.jsp">BACK</a></div>
    </body>
</html>
