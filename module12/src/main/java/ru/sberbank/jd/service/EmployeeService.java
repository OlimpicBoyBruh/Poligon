package ru.sberbank.jd.service;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Repository;
import ru.sberbank.jd.entity.Employee;
import ru.sberbank.jd.repository.EmployeeRepository;

import java.util.Optional;

/**
 * Класс-сервис, взаимодействует с БД.
 */
@Repository
@AllArgsConstructor
public class EmployeeService {
    /**
     * Поле для хранит подключение к БД.
     */
    private EmployeeRepository employeeRepository;

    /**
     * Создает поле в БД.
     *
     * @param employee содержит поля.
     * @return добавленный объект.
     */
    public void create(@NonNull Employee employee) {
        employeeRepository.save(employee);
    }

    /**
     * Обновляет поле в БД employee.
     *
     * @param employee обновляемый объект.
     * @return этот же объект.
     */
    public void update(@NonNull Employee employee) {
        employeeRepository.save(employee);
    }

    /**
     * Ищет поле в БД по id.
     *
     * @param id сотрудника.
     * @return найденный объект.
     */
    public Optional<Employee> findById(@NonNull String id) {
        return employeeRepository.findById(id);
    }

    /**
     * Удаляет поле из БД.
     *
     * @param employee сотрудник.
     */
    public void deleteEmployee(@NonNull Employee employee) {
        employeeRepository.delete(employee);
    }
}
