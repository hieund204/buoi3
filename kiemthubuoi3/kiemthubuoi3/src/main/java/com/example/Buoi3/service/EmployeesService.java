package com.example.Buoi3.service;

import com.example.Buoi3.entity.Employees;

import java.util.ArrayList;
import java.util.List;

public class EmployeesService {

    List<Employees> list = new ArrayList<Employees>();

    public void addEmployee(Employees employee) {
        list.add(employee);
    }
    public List<Employees> getEmployees() {
        return list;
    }

    public void updateEmployee(Employees employee, int id) {
        for (Employees e : list) {
            if (e.getId() == id) {
                e.setId(id);
                e.setFirstName(employee.getFirstName());
                e.setLastName(employee.getLastName());
                e.setEmail(employee.getEmail());
                return;
            }
        }
        throw new IllegalArgumentException("No such employee");
    }
    public void deleteEmployee(int id) {
      boolean result =   list.removeIf(employee -> employee.getId() == id);
      if (!result) {
          throw new IllegalArgumentException("No such employee");
      }
    }


}
