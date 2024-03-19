package ru.sidorov.an.HW._8.Stream.API.and.Optional.service;

import ru.sidorov.an.HW._8.Stream.API.and.Optional.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee findEmployeeWithMaxSalary(int DepartmentId);
    Employee findEmployeeWithMinSalary(int DepartmentId);
    Collection<Employee> findEmployeesByDepartment(int departmentId);
    Map<Integer, List<Employee>> findEmployeesByDepartment();
}
