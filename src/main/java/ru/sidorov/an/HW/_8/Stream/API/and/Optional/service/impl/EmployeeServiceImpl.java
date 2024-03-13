package ru.sidorov.an.HW._8.Stream.API.and.Optional.service.impl;

import org.springframework.stereotype.Service;
import ru.sidorov.an.HW._8.Stream.API.and.Optional.exception.EmployeeAlreadyAddedException;
import ru.sidorov.an.HW._8.Stream.API.and.Optional.exception.EmployeeNotFoundException;
import ru.sidorov.an.HW._8.Stream.API.and.Optional.exception.EmployeeStorgeIsFullException;
import ru.sidorov.an.HW._8.Stream.API.and.Optional.model.Employee;
import ru.sidorov.an.HW._8.Stream.API.and.Optional.service.EmployeeService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final int EMPLOYEE_STORAGE_SIZE = 10;
    private final Map<String, Employee> employees = new HashMap<>();
    @Override
    public Employee add(String firstName, String lastName, int salary, int departmentId){
        Employee employee = new Employee(firstName, lastName, salary, departmentId);
        return add(employee);
    }
    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        return add(employee);
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.containsKey(employee.getFullName())){
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee.getFullName());
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.containsKey(employee.getFullName())){
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Collection<Employee> findAll() {

        return employees.values();
    }

    private Employee add(Employee employee) {
        if (employees.size() == EMPLOYEE_STORAGE_SIZE){
            throw new EmployeeStorgeIsFullException();
        }
        if (employees.containsKey(employee.getFullName())){
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }
}
