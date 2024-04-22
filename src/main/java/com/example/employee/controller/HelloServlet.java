package com.example.employee.controller;

import java.io.*;

import com.example.employee.dto.UserRegisterDto;
import com.example.employee.service.IUserService;
import com.example.employee.service.impl.UserService;
import com.example.employee.util.BCryptUtil;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello



        // login => luu cookkei => loginServlet


        
        
        
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}