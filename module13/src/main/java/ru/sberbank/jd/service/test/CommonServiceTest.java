package ru.sberbank.jd.service.test;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sberbank.jd.entity.LearningClass;
import ru.sberbank.jd.entity.Student;
import ru.sberbank.jd.service.LearningClassService;
import ru.sberbank.jd.service.StudentService;

import java.util.ArrayList;
import java.util.List;
/**
 * Класс заполняет БД, значениями.
 */
@Service
@AllArgsConstructor
class CommonServiceTest {
    private LearningClassService learningClassService;
    private StudentService studentService;


    @PostConstruct
    private void init() {
        List<LearningClass> learningClassList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            LearningClass learningClass = new LearningClass();
            learningClass.setClassNumber("" + i);
            learningClass.setStudentsCount(5);
            learningClassList.add(learningClass);
        }
        learningClassService.saveAll(learningClassList);

        int studentCount = 0;
        int classIndex = 0;
        List<Student> studentList = new ArrayList<>();
        for (int i = 1; i <= 25; i++) {
            if (studentCount == 5) {
                classIndex++;
                studentCount = 0;
            }
            Student student = new Student();
            student.setFirstName("First Name " + i);
            student.setLastName("Last Name " + i);
            student.setLearningClass(learningClassList.get(classIndex));
            studentList.add(student);
            studentCount++;
        }
        studentService.saveAll(studentList);
    }

}
