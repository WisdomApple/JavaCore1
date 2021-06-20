package ConstructorTest;

import java.util.Random;

/**
 * This program demonstrates object construction,
 *
 * @author Cay Horstmann
 * @version 1.01 2004-02-19
 */
public class ConstructorTest {
    public static void main(String[] args) {
        // fill the staff array with three EmployeeTest objects
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Harry", 40000);
        staff[1] = new Employee(60000);
        staff[2] = new Employee();

        // print out information about all EmployeeTest objects
        for (Employee employee : staff) {
            System.out.println("name = " + employee.getName() + ", id = " + employee.getId() + ", salary = " + employee.getSalary());
        }
    }
}

class Employee {
    private static int nextId;

    // static initialization block
    static {
        Random generator = new Random();
        // set nextId to a random number between 0 and 9999
        nextId = generator.nextInt(10000);
    }

    private final int id;
    private String name = "";   // instance field initialization
    private double salary;

    // object initialization block
    {
        id = nextId;
        nextId++;
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // the default constructor
    public Employee() {
        // name initialized to "" see above
        // salary not explicitly set initialized to 0
        // id initialized in initialization block
    }

    public Employee(double salary) {
        // calls the EmployeeTest(String, double) constructor
        this("EmployeeTest #" + nextId, salary);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }
}