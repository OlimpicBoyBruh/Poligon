import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import ru.sberbank.jd.lesson12.StudentRepository;
import ru.sberbank.jd.lesson12.model.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Testcontainers
public class RepositoryTest {

    @Container
    private static final PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres");
    private static Connection connection;
    private static StudentRepository repository;

    @Before
    public void init() {
        postgresContainer.start();
        String jdbcUrl = postgresContainer.getJdbcUrl();
        String username = postgresContainer.getUsername();
        String password = postgresContainer.getPassword();
        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            Database dataBase = DatabaseFactory.getInstance()
                    .findCorrectDatabaseImplementation(new JdbcConnection(connection));
            new Liquibase("db/changelog.xml", new ClassLoaderResourceAccessor(), dataBase).update();
            repository = new StudentRepository(connection);
        } catch (SQLException | LiquibaseException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void createTest() {
        Student student1 = new Student("Artem", "Meshcheriakov", new Date(), true);
        UUID id = repository.create(student1);
        Assert.assertNotNull(id);

        Student student2 = new Student(id, "Stas", "Ivanovich", new Date(), false);
        id = repository.create(student2);
        Assert.assertNotNull(id);
    }

    @Test
    public void selectByIdTest() {
        Student test = new Student("Stas", "Ivanovich", new Date(), false);
        UUID id = repository.create(test);
        Student student = repository.selectById(id);
        test = repository.selectById(UUID.randomUUID());
        Assert.assertNotNull(student);
        Assert.assertNull(test);

        Assert.assertEquals("Stas", student.getFirstName());
        Assert.assertEquals("Ivanovich", student.getLastName());
        Assert.assertFalse(student.isGraduated());
        Assert.assertEquals(id, student.getId());

    }

    @Test
    public void selectAllTest() {
        Student s1 = new Student("Stas", "Ivanovich", new Date(), true);
        Student s2 = new Student("Artem", "Ivanovich", new Date(), false);
        Student s3 = new Student("Ivan", "Ivanovich", new Date(), true);
        Student s4 = new Student("Stas", "Ivanovich", new Date(), false);

        UUID id1 = repository.create(s1);
        UUID id2 = repository.create(s2);
        UUID id3 = repository.create(s3);
        UUID id4 = repository.create(s4);

        List<Student> students = repository.selectAll();
        Assert.assertNotNull(students);
        Assert.assertEquals(4, students.size());

        Assert.assertEquals(id1, students.get(0).getId());
        Assert.assertEquals(id2, students.get(1).getId());
        Assert.assertEquals(id3, students.get(2).getId());
        Assert.assertEquals(id4, students.get(3).getId());
    }

    @Test
    public void removeTest() {
        Student s1 = new Student("Stas", "Ivanovich", new Date(), true);
        Student s2 = new Student("Artem", "Ivanovich", new Date(), false);
        Student s3 = new Student("Ivan", "Ivanovich", new Date(), true);
        Student s4 = new Student("Stas", "Ivanovich", new Date(), false);

        UUID id1 = repository.create(s1);
        UUID id2 = repository.create(s2);
        UUID id3 = repository.create(s3);
        UUID id4 = repository.create(s4);
        List<UUID> id = new ArrayList<>();
        id.add(id1);
        id.add(id2);
        id.add(id3);
        id.add(id4);

        Assert.assertEquals(4, repository.remove(id));

    }


    @AfterClass
    public static void stop() {
        postgresContainer.stop();
    }


}
