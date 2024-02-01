package ru.sberbank.jd.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.sberbank.jd.service.LearningClassService;
import ru.sberbank.jd.service.StudentService;

/**
 * К начальной странице, доступ имеют все пользователи.
 * К списку учеников в классе имеют доступ роли ADMIN, STUDENT.
 */

@Controller
@RequestMapping("/info")
@Slf4j
@AllArgsConstructor
public class InfoController {
    /**
     * Поле-сервис для манипуляций с БД классы.
     */
    private LearningClassService learningClassService;
    /**
     * Поле-сервис для манипуляций с БД ученики.
     */
    private StudentService studentService;

    /**
     * Начальная страница, которая содержит список классов, и кол-во учеников в них.
     *
     * @param model html.
     * @return возвращает HTML представление.
     */
    @GetMapping()
    public String info(Model model) {
        model.addAttribute("list", learningClassService.getAll());
        return "info";
    }

    /**
     * Содержит список учеников в классе.
     * Имеют доступ только роли ADMIN/STUDENT.
     *
     * @param model html.
     * @return возвращает HTML представление.
     */
    @GetMapping("/infoclass/")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_STUDENT')")
    public String infoClass(Model model, @RequestParam("class") String classNumber) {
        model.addAttribute("classList", studentService.findByClass(classNumber));
        return "infoClass";
    }

}
