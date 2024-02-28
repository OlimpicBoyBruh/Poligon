package ru.sberbank.jd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.sberbank.jd.entity.Student;

import java.util.List;

/**
 * Репозиторий для управления БД student.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    /**
     * Запрос возвращает список всех студентов в определенном классе.
     *
     * @param numberClass наименование класса.
     * @return Список учеников в данном классе.
     */
    @Query(value = "SELECT * FROM student WHERE learning_class_class_number = :numberClass", nativeQuery = true)
    List<Student> findByNumberClass(@Param("numberClass") String numberClass);
}
