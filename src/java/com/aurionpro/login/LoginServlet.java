/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aurionpro.login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author abhinav.kumar
 */
public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String uri = request.getRequestURI();
        if (uri.equals("/loginapp/login")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            boolean status = VerifyLogin.checkLogin(username, password);

            if (status) {
                RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
                rd.include(request, response);
            } else {
                out.print("Sorry,login failed. please try again.");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.include(request, response);
            }
        } else if (uri.equals("/loginapp/update")) {

            String username = request.getParameter("username");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            String tempId = request.getParameter("id");
            int id = Integer.parseInt(tempId);
            int status = UpdateUser.update(id, username, address, phone);
            if (status > 0) {
                out.print("ACCOUNT HAS BEEN UPDATED");
                RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
                rd.include(request, response);
            } else {
                out.print("Sorry,Updation failed. please try later");
                RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
                rd.include(request, response);
            }
        } else if (uri.equals("/loginapp/delete")) {

            String tempId = request.getParameter("id");
            int id = Integer.parseInt(tempId);            
            int status = DeleteUser.delete(id);
            if (status > 0) {
                out.print("WELCOME! ACCOUNT HAS BEEN DELETED");
                RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
                rd.include(request, response);
            } else {
                out.print("Sorry,deletion failed. please try later");
                RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
                rd.include(request, response);
            }
        } else {

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");

            RegisterUser register = new RegisterUser();
            int status = register.register(username, password, address, phone);
//            out.print(register.toString());

            if (status > 0) {
                out.print("WELCOME! YOUR ACCOUNT HAS OPENED");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.include(request, response);
            } else {
                out.print("Sorry,Registration failed. please try later");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.include(request, response);
            }
        }

        out.close();
    }

}
