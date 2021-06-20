package PackageTest;

import com.Employee;

import static java.lang.System.out;

/**
 * This program demonstrates the use of packages ,
 *
 * @author Cay Horstmann
 * @version 1.11 2004-02-19
 */
public class PackageTest {
    public static void main(String[] args) {
        // because of the import statement , we don't have to use
        // com.Employee here
        Employee harry = new Employee("Harry", 5000, 1989, 10, 1);

        harry.raiseSalary(5);

        // because of the static import statement, we don't have to use System.out here
        out.println("name = " + harry.getName() + ", salary = " + harry.getSalary());
    }
}
