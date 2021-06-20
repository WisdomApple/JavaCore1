package interfaces;

import java.util.Arrays;

/**
 * This program demonstrates the use of the Comparable interface.
 *
 * @author Cay Horstmann
 * @version 1.30 2004-02-27
 */
public class EmployeeSortTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Harry Hacker", 35000);
        staff[1] = new Employee("Carl Cracker", 75000);
        staff[2] = new Employee("Tony Test", 38000);

        Arrays.sort(staff);

        // print out information about all Employee objects
        for (Employee employee : staff)
            System.out.println("name = " + employee.getName() + ", salary = " + employee.getSalary());
    }
}
