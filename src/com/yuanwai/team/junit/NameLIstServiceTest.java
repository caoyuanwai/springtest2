package com.yuanwai.team.junit;

import com.yuanwai.team.domain.Employee;
import com.yuanwai.team.service.NameListService;
import com.yuanwai.team.service.TeamException;
import org.junit.Test;

public class NameLIstServiceTest {
    @Test
    public void testGetAllEmployees() {
        NameListService service = new NameListService();
        Employee[] employees = service.getAllEmployees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }

    @Test
    public void testGetEmployee() {
        NameListService s = new NameListService();
        int id = 101;
        Employee employee = null;
        try {
            employee = s.getEmployee(id);
        } catch (TeamException e) {
            e.printStackTrace();
        }
        System.out.println(employee);
    }
}
