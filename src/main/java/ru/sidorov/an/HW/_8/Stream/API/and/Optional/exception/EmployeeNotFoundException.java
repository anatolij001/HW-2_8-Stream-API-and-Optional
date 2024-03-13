package ru.sidorov.an.HW._8.Stream.API.and.Optional.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException() {
        super("Сотрудник не найден!");
    }
}
