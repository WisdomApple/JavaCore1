package StaticTest;

/**
 * This program demonstrates static methods.
 *
 * @author Cay Horstmann
 * @version 1.01 2004-02-19
 */
public class StaticTest {
    public static void main(String[] args) {
        // fill the staff array with three EmployeeTest objects
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Tom", 75000);
        staff[1] = new Employee("Disk", 50000);
        staff[2] = new Employee("Harry", 40000);

        // print out information about all EmployeeTest objects
        for (Employee employee2 : staff) {
            employee2.setId();
            System.out.println("name = " + employee2.getName() + ", id = " + employee2.getId() + ", salary = "
                    + employee2.getSalary());
        }
    }
}

class Employee {
    private static int nextId = 1;

    private final String name;
    private final double salary;
    private int id;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        id = 0;
    }

    public static int getNextId() {
        return nextId;   // returns static field
    }

    // unit test
    public static void main(String[] args) {
        Employee employee2 = new Employee("Harry", 50000);
        System.out.println(employee2.getName() + " " + employee2.getSalary());
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

    public void setId() {
        id = nextId;    // set id to next available id
        nextId++;
    }
}