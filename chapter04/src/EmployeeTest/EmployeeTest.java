package EmployeeTest;

import java.time.LocalDate;

/**
 * This program tests the chapter04.EmployeeTest.EmployeeTest class.
 *
 * @author Cay Horstmann
 * @version 1.12 2015-05-08
 */
public class EmployeeTest {
    public static void main(String[] args) {
        // fill the staff array with three chapter04.EmployeeTest.EmployeeTest objects
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

        // raise everyone's salary by 5%
        for (Employee employee : staff)
            employee.raiseSalary(5);
        // print out information about all EmployeeTest objects
        for (Employee employee : staff) {
            System.out.println("name = " + employee.getName() +
                    ", salary = " + employee.getSalary() +
                    ", hireDay = " + employee.getHireDay()
            );
        }
    }
}

class Employee {
    private final String name;
    private final LocalDate hireDay;
    private double salary;

    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
