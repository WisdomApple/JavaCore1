package arrayList;

import equals.Employee;

import java.util.ArrayList;

/**
 * This program demonstrates the ArrayList class.
 *
 * @author Cay Horstmann
 * @version 1.11 2012-01-26
 */
public class ArrayListTest {
    public static void main(String[] args) {
        // fill the staff array list with three Employee objects
        ArrayList<Employee> staff = new ArrayList<Employee>();

        staff.add(new Employee("Carl Cracker", 75000, 1987, 12, 15));
        staff.add(new Employee("Harry Hacker", 50000, 1989, 10, 1));
        staff.add(new Employee("Tony Tester", 40000, 1990, 3, 15));

        // raise everyone's salary by 5%
        for (Employee employee : staff) {
            employee.raiseSalary(5);
        }

        // print out information about all Employee objects
        for (Employee employee : staff) {
            System.out.println("name = " + employee.getName() +
                    ", salary = " + employee.getSalary() +
                    ", hireDay = " + employee.getHireDay());
        }
    }
}
