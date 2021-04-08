package com.example.Demo_ORM.controllers;

import com.example.Demo_ORM.DaoImpl.LoginDao;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDao loginDao;

    public void init() {
        loginDao = new LoginDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
      if(path.equals("/log")){
        try {
            authenticate(request, response);
            System.out.println("ok");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (loginDao.validate(username, password)==true) {
            System.out.println("Login successful");

            RequestDispatcher dispatcher = request.getRequestDispatcher("login-success.jsp");
            dispatcher.forward(request, response);
        } else {
            throw new Exception("Login not successful..");
        }
    }
}