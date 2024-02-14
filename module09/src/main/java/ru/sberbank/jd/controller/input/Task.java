package ru.sberbank.jd.controller.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

/**
 * Класс для хранения данных о задаче.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    /**
     * Уникальный идентификатор задачи.
     */
    private UUID id = UUID.randomUUID();
    /**
     * Поле для хранения имени владельца задачи.
     */
    private String owner;
    /**
     * Поле для хранения задачи.
     */
    private String description;

    /**
     * Возвращает имя владельца задачи.
     *
     * @return String имя.
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Возвращает задачу.
     *
     * @return String задача.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Возвращает идентификатор задачи.
     *
     * @return id задачи.
     */
    public UUID getId() {
        return id;
    }

    /**
     * Возвращает описание объекта.
     *
     * @return String всех полей.
     */
    @Override
    public String toString() {
        return "TaskInput{"
                + "owner='" + owner + '\''
                + ", description='" + description + '\''
                + ", UUID='" + id + '\''
                + '}';
    }
}
