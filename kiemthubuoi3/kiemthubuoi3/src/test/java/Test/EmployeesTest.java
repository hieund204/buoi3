package Test;

import com.example.Buoi3.entity.Employees;
import com.example.Buoi3.service.EmployeesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeesTest {
    private EmployeesService employeesService;

    @BeforeEach
    void setUp() {
        employeesService = new EmployeesService();
    }

    @Test
    void addEmployee_Valid() {
        Employees employees = new Employees(1,"Pham","B" , "b@gmail.com" );
        employeesService.addEmployee(employees);
        assertEquals(1,employeesService.getEmployees().size());
        assertEquals(employees,employeesService.getEmployees().get(0));
    }
    @Test
    void addEmployee_Valid1() {
        Employees employees = new Employees(2,"Pham","B" , "b@gmail.com" );
        employeesService.addEmployee(employees);
        assertEquals(1,employeesService.getEmployees().size());
        assertEquals(employees,employeesService.getEmployees().get(0));
    }
    @Test
    void addEmployee_Valid2() {
        Employees employees = new Employees(5,"Pham","B" , "b@gmail.com" );
        employeesService.addEmployee(employees);
        assertEquals(1,employeesService.getEmployees().size());
        assertEquals(employees,employeesService.getEmployees().get(0));
    }
    @Test
    void addEmployee_Valid3() {
        Employees employees = new Employees(10,"Pham","B" , "b@gmail.com" );
        employeesService.addEmployee(employees);
        assertEquals(1,employeesService.getEmployees().size());
        assertEquals(employees,employeesService.getEmployees().get(0));
    }
    @Test
    void updateEmployee_Valid() {
        Employees employees = new Employees(1,"Pham","B" , "b@gmail.com" );
        employeesService.addEmployee(employees);
        Employees employees1 = new Employees(1,"Pham","N" , "b@gmail.com" );
        employeesService.updateEmployee(employees1 , 1);
        assertEquals("N",employeesService.getEmployees().get(0).getLastName());
    }

    @Test
    void updateEmployee_Valid1() {
        Employees employees = new Employees(1,"Pham","B" , "b@gmail.com" );
        employeesService.addEmployee(employees);
        Employees employees1 = new Employees(1,"Nguyen","B" , "b@gmail.com" );
        employeesService.updateEmployee(employees1 , 1);
        assertEquals("Nguyen",employeesService.getEmployees().get(0).getFirstName());
    }
    @Test
    void updateEmployee_Valid2() {
        Employees employees = new Employees(1,"Pham","B" , "b@gmail.com" );
        employeesService.addEmployee(employees);
        Employees employees1 = new Employees(1,"Pham","B" , "bc@gmail.com" );
        employeesService.updateEmployee(employees1 , 1);
        assertEquals("bc@gmail.com",employeesService.getEmployees().get(0).getEmail());
    }
    @Test
    void updateEmployee_Valid3() {
        Employees employees = new Employees(1,"Pham","B" , "b@gmail.com" );
        employeesService.addEmployee(employees);
        Employees employees1 = new Employees(1,"Tran","N" , "b@gmail.com" );
        employeesService.updateEmployee(employees1 , 1);
        assertEquals("Tran",employeesService.getEmployees().get(0).getFirstName());
    }
    @Test
    void deleteEmployee_Valid() {
        Employees employees = new Employees(1,"Pham" , "B" , "b@gmail.com");
        employeesService.addEmployee(employees);
        employeesService.deleteEmployee(1);
        assertEquals(0,employeesService.getEmployees().size());
        assertEquals(employees,employeesService.getEmployees().get(0));

    }
    @Test
    void deleteEmployee_Invalid() {
        Employees employees = new Employees(1,"Pham" , "B" , "b@gmail.com");
        employeesService.addEmployee(employees);
        employeesService.deleteEmployee(2);
        assertEquals(0,employeesService.getEmployees().size());
        assertEquals(employees,employeesService.getEmployees().get(0));

    }





}
