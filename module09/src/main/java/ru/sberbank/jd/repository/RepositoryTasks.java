package ru.sberbank.jd.repository;

import ru.sberbank.jd.controller.input.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Репозиторий задач, имеет методы add, get, remove.
 */

public class RepositoryTasks {
    /**
     * Поле хранящее Tusk.
     */
    List<Task> repository = new ArrayList<>();

    /**
     * Добавляет задачу в репозиторий.
     *
     * @param task задача.
     * @return результат выполнения.
     */
    public boolean add(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Значение не может быть null");
        }
        return repository.add(task);
    }

    /**
     * Удаляет задачу в репозиторий.
     *
     * @param id задачи.
     * @return результат выполнения.
     */
    public Task remove(UUID id) {
        Task task = get(id);
        repository.remove(task);
        return task;

    }

    /**
     * Возвращает задачу по UUID.
     *
     * @param id уникальный идентификатор задачи.
     * @return найденный объект Task.
     */
    public Task get(UUID id) {
        for (Task task : repository) {
            if (task.getId().equals(id)) {
                return task;
            }
        }
        return null;
    }
}
