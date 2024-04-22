package com.example.employee.repository.impl;

import com.example.employee.dto.UserChangePasswordDTO;
import com.example.employee.dto.UserRegisterDto;
import com.example.employee.model.User;
import com.example.employee.repository.IUserRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {

    @Override
    public User findByUserName(String username) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(
                    "select id, username, password from user where username = ?;"
            );
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            User user;
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<String> findRolesByUsername(String username) {
        List<String> roles = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(
                    "select r.name as role from user u inner join user_role ur on u.id = ur.user_id\n" +
                            "inner join role r on ur.role_id = r.id where u.username = ?;"
            );

            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                roles.add(resultSet.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roles;
    }

    @Override
    public void save(UserRegisterDto userRegisterDto) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(
                    "insert into user(username, password) values (?, ?)"
            );
            preparedStatement.setString(1, userRegisterDto.getUsername());
            preparedStatement.setString(2, userRegisterDto.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void change(UserChangePasswordDTO userChangePasswordDTO) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(
                    "update user set password = ? where username = ? "
            );
            preparedStatement.setString(1, userChangePasswordDTO.getNewPassword());
            preparedStatement.setString(2, userChangePasswordDTO.getUsername());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
