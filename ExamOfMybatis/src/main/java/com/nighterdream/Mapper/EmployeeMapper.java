package com.nighterdream.Mapper;

import com.nighterdream.Pojo.Employee;

public interface EmployeeMapper {
    Employee findEmployee(int id);

    void addEmployee(Employee employee);

    int updateEmployee(Employee employee);

    void deleteEmployee(int id);
}
