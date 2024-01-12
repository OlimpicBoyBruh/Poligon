package ru.sberbank.jd.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.sberbank.jd.controller.input.Task;
import ru.sberbank.jd.repository.TasksRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.UUID;

/**
 * Служит для записи/чтения задач.
 */
@WebServlet(name = "Tasks", value = {"/task"})
public class TasksServlet extends HttpServlet {
    /**
     * Поле для записи/чтения json формата.
     */
    private ObjectMapper objectMapper;
    /**
     * Поле для хранения Task.
     */
    private TasksRepository repository;

    /**
     * Инициализирует поля.
     *
     * @param config настройка.
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.objectMapper = new ObjectMapper();
        this.repository = new TasksRepository();
    }

    /**
     * Формирует ответ по запросу.
     * Пример запроса: Get <a href="http://localhost:8080/module09/task?id.">...</a>
     *
     * @param req  запрос.
     * @param resp ответ.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var id = req.getParameter("id");
        Task task = repository.get(UUID.fromString(id));
        String answer = objectMapper.writeValueAsString(task);

        resp.getOutputStream().write(answer.getBytes());
        resp.getOutputStream().flush();
    }

    /**
     * Создает Task и записывает его в repository.
     * Пример запроса: Post <a href="http://localhost:8080/module09/task">...</a>
     *
     * @param req  запрос.
     * @param resp ответ.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = readBody(req);

        Task taskInput = objectMapper.readValue(result.toString(), Task.class);
        repository.add(taskInput);
        String answer = objectMapper.writeValueAsString(taskInput);

        resp.getOutputStream().write(answer.getBytes());
        resp.getOutputStream().flush();
    }

    /**
     * Удаляет Task из репозитория по id.
     * Пример запроса: DELETE <a href="http://localhost:8080/module09/task?id=*">...</a>
     *
     * @param req  запрос.
     * @param resp ответ.
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var id = req.getParameter("id");
        Task task = repository.remove(UUID.fromString(id));
        String answer = objectMapper.writeValueAsString(task);

        resp.getOutputStream().write(answer.getBytes());
        resp.getOutputStream().flush();
    }

    /**
     * Читает запрос и возвращает его.
     *
     * @param req запрос.
     * @return возвращает body в String
     */
    private static String readBody(HttpServletRequest req) {
        StringBuilder result = new StringBuilder();
        BufferedReader reader;
        try {
            reader = req.getReader();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Не удается считать");
        }
        return result.toString();
    }
}
