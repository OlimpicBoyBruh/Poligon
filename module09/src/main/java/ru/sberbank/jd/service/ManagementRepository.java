package ru.sberbank.jd.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.sberbank.jd.controller.input.Task;
import ru.sberbank.jd.repository.TasksRepository;
import java.util.UUID;

/**
 * Класс для управления репозиторием.
 */
public class ManagementRepository {
    /**
     * Чтение/запись json формата.
     */
    private ObjectMapper mapper;
    /**
     * Репозиторий для управления.
     */
    private TasksRepository repository;

    /**
     * Конструктор инициализации полей.
     */
    public ManagementRepository() {
        mapper = new ObjectMapper();
        repository = new TasksRepository();
    }

    /**
     * Формирует ответ, на основе переданных данных.
     *
     * @param id идентификатор Task.
     * @return готовый ответ get.
     */
    public String getRepository(String id) {
        Task task = repository.get(UUID.fromString(id));
        try {
            return mapper.writeValueAsString(task);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Не удалось считать данные!");
        }
    }

    /**
     * Формирует ответ, на основе переданных данных.
     *
     * @param request запрос клиента.
     * @return готовый ответ post.
     */
    public String postRepository(String request) {
        try {
            Task taskInput = mapper.readValue(request.toString(), Task.class);
            repository.add(taskInput);
            return mapper.writeValueAsString(taskInput);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Deserialization Error");
        }
    }

    /**
     * Формирует ответ, на основе переданных данных.
     *
     * @param id идентификатор Task.
     * @return готовый ответ Delete.
     */
    public String DelFromRepository(String id) {
        Task task = repository.remove(UUID.fromString(id));
        try {
            return mapper.writeValueAsString(task);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Не удалось считать данные!");
        }
    }


}
