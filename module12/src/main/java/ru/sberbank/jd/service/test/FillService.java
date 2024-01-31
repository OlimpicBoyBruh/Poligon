package ru.sberbank.jd.service.test;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sberbank.jd.entity.Department;
import ru.sberbank.jd.entity.Employee;
import ru.sberbank.jd.entity.Project;
import ru.sberbank.jd.repository.DepartmentRepository;
import ru.sberbank.jd.repository.EmployeeRepository;
import ru.sberbank.jd.repository.ProjectRepository;
/**
 * Класс необходим для заполнения БД тестовыми данными.
 */
@Service
@AllArgsConstructor
public class FillService {
    private DepartmentRepository departmentRepository;
    private EmployeeRepository employeeRepository;
    private ProjectRepository projectRepository;


    @PostConstruct
    public void init() {
        Department department = new Department();
        department.setId("1616/1616");
        department.setDepartmentName("GPM");

        Employee employee = new Employee();
        employee.setPersonalId("76050");
        employee.setFirstName("Artem");
        employee.setLastName("Ivanov");
        employee.setDepartment(department);


        departmentRepository.save(department);
        employeeRepository.save(employee);

        department.setDirector(employee);
        departmentRepository.save(department);

        Department department1 = new Department();
        department1.setId("1515/1515");
        department1.setDepartmentName("UROK");

        Employee employee1 = new Employee();
        employee1.setPersonalId("65017");
        employee1.setFirstName("Sergey");
        employee1.setLastName("Petrushka");
        employee1.setDepartment(department1);

        departmentRepository.save(department1);
        employeeRepository.save(employee1);

        department1.setDirector(employee1);
        departmentRepository.save(department1);

        Project fixSmartCare = new Project();
        fixSmartCare.setProjectName("Fix smartCare");
        fixSmartCare.setRole("Main developer");
        fixSmartCare.setEmployee(employee);

        Project fixArmCzk = new Project();
        fixArmCzk.setProjectName("Fix ARM CZK");
        fixArmCzk.setRole("Main developer");
        fixArmCzk.setEmployee(employee1);

        projectRepository.save(fixArmCzk);
        projectRepository.save(fixSmartCare);

        employee.setProject(fixSmartCare);
        employee1.setProject(fixArmCzk);

        employeeRepository.save(employee);
        employeeRepository.save(employee1);
    }
}
