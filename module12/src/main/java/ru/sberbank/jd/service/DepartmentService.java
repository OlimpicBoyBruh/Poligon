package ru.sberbank.jd.service;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import ru.sberbank.jd.entity.Department;
import ru.sberbank.jd.repository.DepartmentRepository;

import java.util.Optional;

/**
 * Класс-сервис, взаимодействует с БД.
 */
@Service
@AllArgsConstructor
public class DepartmentService {
    /**
     * Поле для хранит подключение к БД.
     */
    private DepartmentRepository departmentRepository;

    /**
     * Создает новое поле в БД project.
     *
     * @param department новый отдел.
     * @return этот же отдел.
     */
    public Department create(@NonNull Department department) {
        return departmentRepository.save(department);
    }

    /**
     * Обновляет поле в БД project.
     *
     * @param department новый отдел.
     * @return этот же отдел.
     */
    public Department update(@NonNull Department department) {
        return departmentRepository.save(department);
    }

    /**
     * Находит поле в БД department.
     *
     * @param id отдела.
     * @return контейнер Optional.
     */
    public Optional<Department> findById(@NonNull String id) {
        return departmentRepository.findById(id);
    }

    /**
     * Удаляет отдел из БД.
     *
     * @param department удаляемый отдел.
     */
    public void deleteDepartment(@NonNull Department department) {
        departmentRepository.delete(department);
    }

}
