package ru.sberbank.jd.service;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import ru.sberbank.jd.entity.Project;
import ru.sberbank.jd.repository.ProjectRepository;
import java.util.Optional;

/**
 * Класс-сервис, взаимодействует с БД.
 */
@Service
@AllArgsConstructor
public class ProjectService {
    /**
     * Поле для хранит подключение к БД.
     */
    private ProjectRepository projectRepository;

    /**
     * Создает новое поле в БД project.
     *
     * @param project новый проект.
     * @return этот же проект.
     */
    public Project create(@NonNull Project project) {
        return projectRepository.save(project);
    }

    /**
     * Обновляет поле в БД project.
     *
     * @param project новый проект.
     * @return этот же проект.
     */
    public Project update(@NonNull Project project) {
        return projectRepository.save(project);
    }

    /**
     * Находит поле в БД по ID.
     *
     * @param projectId id проекта.
     * @return найденный проект.
     */
    public Optional<Project> findById(@NonNull String projectId) {
        return projectRepository.findById(projectId);
    }

    /**
     * Удаляет поле в БД.
     *
     * @param project удаляет из БД.
     */
    public void deleteProject(Project project) {
        projectRepository.delete(project);
    }
}
