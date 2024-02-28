package ru.sberbank.jd.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sberbank.jd.entity.LearningClass;
import ru.sberbank.jd.entity.Student;
import ru.sberbank.jd.service.LearningClassService;
import ru.sberbank.jd.service.StudentService;

import java.util.Optional;

/**
 * Контроллер, доступ к endpoint имеет только пользователь с ролью ADMIN.
 */
@Controller
@RequestMapping(value = "/admin")
@AllArgsConstructor
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminController {
    /**
     * Поле-сервис для манипуляций с БД классы.
     */
    private LearningClassService learningClassService;
    /**
     * Поле-сервис для манипуляций с БД ученики.
     */
    private StudentService studentService;

    /**
     * Страница для заполнения информации о новом ученике.
     *
     * @return возвращает HTML представление
     */
    @GetMapping("/create")
    public String addStudentView() {
        return "add_student";
    }

    /**
     * Создает в базе данных нового ученика.
     *
     * @param model       html модель.
     * @param numberClass класс ученика.
     * @param firstName   имя ученика.
     * @param lastName    Фамилия ученика.
     * @return возвращает HTML представление
     */
    @PostMapping("/add")
    public String addStudent(Model model, @RequestParam("firstName") String firstName,
                             @RequestParam("lastName") String lastName,
                             @RequestParam("classNumber") String numberClass) {
        model.addAttribute("list", learningClassService.getAll());
        Student student = new Student();
        Optional<LearningClass> learningClass = learningClassService.get(numberClass);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setLearningClass(learningClass.get());
        studentService.save(student);
        return "info";
    }
}
