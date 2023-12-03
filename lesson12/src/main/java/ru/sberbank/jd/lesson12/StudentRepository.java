package ru.sberbank.jd.lesson12;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import ru.sberbank.jd.lesson12.model.Student;

/**
 * Класс работы с таблицей - students.
 */
public class StudentRepository implements StudentsRepositoryCrud {

    /**
     * Поле для подключения к базе данных.
     */
    private final Connection connection;
    /**
     * Поле выполнения SQL-запроса.
     */
    private PreparedStatement preparedStatement;
    /**
     * Поле для получения результата SELECT SQL-запроса.
     */
    private ResultSet resultSet;

    public StudentRepository(Connection connection) {
        this.connection = connection;
    }

    /**
     * Создание записи в БД.
     * id у student должен быть null, иначе требуется вызов update.
     * id генерируем через UUID.randomUUID()
     *
     * @param student - заполненный объект
     * @return сгенерированный UUID
     */
    @Override
    public UUID create(Student student) {
        if (student == null) {
            throw new IllegalArgumentException();
        }
        if (student.getId() == null) {
            student.setId(UUID.randomUUID());
            try {
                String command = "INSERT INTO Students "
                        + "(id, first_name, last_name, birth_date, is_graduated) VALUES (?, ?, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(command);

                preparedStatement.setString(1, student.getId().toString());
                preparedStatement.setString(2, student.getFirstName());
                preparedStatement.setString(3, student.getLastName());
                preparedStatement.setDate(4, new Date(student.getBirthDate().getTime()));
                preparedStatement.setBoolean(5, student.isGraduated());

                preparedStatement.executeUpdate();
                return student.getId();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            update(student);
            return student.getId();
        }
    }

    /**
     * Получение записи по id из БД.
     *
     * @param id идентификатор записи
     * @return запись
     */
    @Override
    public Student selectById(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        Student student = null;
        String sql = "SELECT * FROM students WHERE id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id.toString());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                Date birthDateString = resultSet.getDate(4);

                boolean isGraduated = resultSet.getBoolean(5);
                student = new Student(id, firstName, lastName, birthDateString, isGraduated);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }


    /**
     * Получение всех записей из БД.
     *
     * @return записи
     */
    @Override
    public List<Student> selectAll() {
        List<Student> students = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM students";
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                UUID id = UUID.fromString(resultSet.getString(1));
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                Date birthDay = resultSet.getDate(4);
                boolean isGraduated = resultSet.getBoolean(5);
                Student student = new Student(id, firstName, lastName, birthDay, isGraduated);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    /**
     * Обновление записи в БД.
     *
     * @param student измененная запись
     * @return количество обновленных записей
     */
    @Override
    public int update(Student student) {
        int rowsAffected;
        String sql = "UPDATE students SET first_name = ? , last_name = ? , birth_date = ? "
                + " , is_graduated = ?  WHERE id = ? ";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setDate(3, new java.sql.Date(student.getBirthDate().getTime()));
            preparedStatement.setBoolean(4, student.isGraduated());
            preparedStatement.setString(5, student.getId().toString());

            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowsAffected;
    }

    /**
     * Удаление указанных записей по id.
     *
     * @param idList список идентификаторов записей
     * @return количество удаленных записей
     */
    @Override
    public int remove(List<UUID> idList) {
        if (idList == null) {
            throw new IllegalArgumentException();
        }
        int rowsAffected = 0;
        String sql = "DELETE FROM students WHERE id = ?";
        for (UUID id : idList) {
            try {
                preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setString(1, id.toString());
                rowsAffected += preparedStatement.executeUpdate();

            } catch (SQLException e) {
                System.out.println("UUID: " + id + " not found");
            }
        }
        return rowsAffected;
    }

    public Connection getConnection() {
        return connection;
    }

}
