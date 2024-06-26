package com.example.employee.repository.impl;

import com.example.employee.model.Department;
import com.example.employee.repository.IDepartmentRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository implements IDepartmentRepository {

    @Override
    public List<Department> findAll() {
        List<Department> departmentList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(
                    "select id, name from department"
            );
            ResultSet resultSet = preparedStatement.executeQuery();
            Department department;
            while (resultSet.next()) {
                department = new Department();
                department.setId(resultSet.getInt("id"));
                department.setName(resultSet.getString("name"));

                departmentList.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departmentList;

    }
}
