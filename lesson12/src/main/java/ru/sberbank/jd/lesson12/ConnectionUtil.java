package ru.sberbank.jd.lesson12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Класс для инициализации подключения к БД.
 */
public class ConnectionUtil {
    /**
     * Метод возвращает подключение.
     *
     * @return объект подключения.
     */
    public static Connection getConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres",
                    "postgres", "password");
        } catch (SQLException e) {
            throw new RuntimeException("No connect", e);
        }
        return connection;
    }
}
