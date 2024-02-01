package ru.sberbank.jd.service;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.sberbank.jd.entity.LearningClass;
import ru.sberbank.jd.repository.LearningClassRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервис для манипуляций с БД учебного класса.
 */
@Service
@AllArgsConstructor
public class LearningClassService {
    /**
     * Репозиторий учебного класса.
     */
    private LearningClassRepository learningClassRepository;

    /**
     * Возвращает класс по его наименованию.
     *
     * @param numberClass наименование класса.
     * @return найденный класс.
     */
    public Optional<LearningClass> get(String numberClass) {
        return learningClassRepository.findById(numberClass);
    }

    /**
     * Возвращает все классы.
     *
     * @return найденные классы.
     */
    @ModelAttribute("list")
    public List<LearningClass> getAll() {
        return learningClassRepository.findAll();
    }

    /**
     * Сохраняет новый класс в БД.
     *
     * @param learningClass новый класс.
     * @return сохраненный класс.
     */
    public LearningClass save(@NonNull LearningClass learningClass) {
        return learningClassRepository.save(learningClass);
    }

    /**
     * Сохраняет новые классы в БД.
     *
     * @param list новые классы.
     */
    public void saveAll(List<LearningClass> list) {
        learningClassRepository.saveAll(list);
    }
}
