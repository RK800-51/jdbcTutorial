package org.example;


import org.example.businesslogic.Util;
import org.example.entity.Address;
import org.example.entity.EmplProj;
import org.example.entity.Employee;
import org.example.entity.Project;
import org.example.service.AddressService;
import org.example.service.EmplProjService;
import org.example.service.EmployeeService;
import org.example.service.ProjectService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public class App
{
    public static void main( String[] args ) throws SQLException {
        AddressService addressService = new AddressService();
        EmployeeService employeeService = new EmployeeService();
        ProjectService projectService = new ProjectService();
        EmplProjService emplProjService = new EmplProjService();

        Address address = new Address();
        address.setId(1L);
        address.setCountry("DC");
        address.setCity("Gotham");
        address.setStreet("Arkham Street");
        address.setPostCode("12345");

        Employee employee = new Employee();
        employee.setId(1L);
        employee.setFirstName("James");
        employee.setLastName("Gordon");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1939, Calendar.MAY, 1);

        employee.setBirthDay(new Date(calendar.getTime().getTime()));
        employee.setAddressID(address.getId());

        Project project = new Project();
        project.setId(1L);
        project.setTitle("Gotham City Police Department Comissioner");

        EmplProj emplProj = new EmplProj();
        emplProj.setEmployeeId(employee.getId());
        emplProj.setProjectId(project.getId());

        try {
//            addressService.add(address);
//            employeeService.add(employee);
//            projectService.add(project);
//            emplProjService.add(emplProj);
            List<Address> addressList = addressService.getAll();
            for (Address a : addressList) {
                System.out.println(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // System.out.println(addressService.getAll());
    }
}
