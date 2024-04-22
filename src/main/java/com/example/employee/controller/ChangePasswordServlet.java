package com.example.employee.controller;

import com.example.employee.dto.UserChangePasswordDTO;
import com.example.employee.dto.UserDetail;
import com.example.employee.service.IUserService;
import com.example.employee.service.impl.UserService;
import com.example.employee.util.BCryptUtil;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "ChangePasswordServlet", value = "/changePassword")
public class ChangePasswordServlet extends HttpServlet {
    private final IUserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        request.getRequestDispatcher("/changePassword.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");

        String pwBcry =  BCryptUtil.hashPassword(oldPassword);
        String npwBcry =  BCryptUtil.hashPassword(newPassword);
        if (Objects.equals(oldPassword, newPassword)) {
            request.setAttribute("massage", "Không được trùng với mật khẩu cũ");
            request.getRequestDispatcher("/changePassword.jsp").forward(request, response);
            return;
        }
        UserChangePasswordDTO userChangePasswordDTO = new UserChangePasswordDTO();
        userChangePasswordDTO.setNewPassword(npwBcry);
        userChangePasswordDTO.setUsername(username);
        userService.change(userChangePasswordDTO);
        HttpSession session = request.getSession();
        session.setAttribute("username", userChangePasswordDTO.getUsername()); // đặt tên gì cx dc
        response.sendRedirect("/login.jsp");
    }
}
