package ru.sberbank.jd.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sberbank.jd.entity.Student;
import ru.sberbank.jd.repository.StudentRepository;

import java.util.List;

/**
 * Сервис для манипуляций с БД учеников.
 */
@Service
@AllArgsConstructor
public class StudentService {
    /**
     * Поле-сервис для манипуляций с БД ученики.
     */
    private StudentRepository studentRepository;

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    /**
     * Ищет всех учеников.
     *
     * @return Список всех учеников.
     */
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    /**
     * Сохраняет новых учеников.
     *
     * @param studentList Список новых учеников.
     */
    public void saveAll(List<Student> studentList) {
        studentRepository.saveAll(studentList);
    }

    /**
     * Возвращает всех учеников в классе.
     *
     * @param numberClass наименование класса.
     * @return список учеников
     */
    public List<Student> findByClass(String numberClass) {
        return studentRepository.findByNumberClass(numberClass);
    }

}
