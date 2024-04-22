package com.example.employee.repository;

import com.example.employee.dto.UserChangePasswordDTO;
import com.example.employee.dto.UserRegisterDto;
import com.example.employee.model.User;

import java.util.List;

public interface IUserRepository {
    User findByUserName(String username);
    List<String> findRolesByUsername(String username);

    void save(UserRegisterDto userRegisterDto);

    void change(UserChangePasswordDTO userChangePasswordDTO);
}
