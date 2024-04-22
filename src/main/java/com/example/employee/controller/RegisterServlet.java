package com.example.employee.controller;

import com.example.employee.dto.UserRegisterDto;
import com.example.employee.service.IUserService;
import com.example.employee.service.impl.UserService;
import com.example.employee.util.BCryptUtil;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;

import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    private final IUserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String pwBcry =  BCryptUtil.hashPassword(password);

        UserRegisterDto userRegisterDto = new UserRegisterDto();
        userRegisterDto.setPassword(pwBcry);
        userRegisterDto.setUsername(username);
        userService.save(userRegisterDto);
        HttpSession session = request.getSession();
        session.setAttribute("username", userRegisterDto.getUsername()); // đặt tên gì cx dc
        response.sendRedirect("/login.jsp");
    }
}
