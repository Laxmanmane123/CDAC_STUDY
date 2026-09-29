package day2;

import java.util.Arrays;
import day2.CompareProgram5.Department;
import day2.CompareProgram5.Designation;

public class CompareProgram5 {

    public static void main(String[] args) {

        Printer p = new Printer();

        Employee[] list = {
                new Employee(9, "Sandeep", Designation.MANAGER, Department.IT, 65000),
                new Employee(1, "Laxman", Designation.DEVELOPER, Department.IT, 70000),
                new Employee(2, "Ramesh", Designation.TESTER, Department.IT, 40000),
                new Employee(3, "Suresh", Designation.MANAGER, Department.HR, 60000),
                new Employee(4, "Mahesh", Designation.DEVELOPER, Department.IT, 55000),
                new Employee(5, "Rajesh", Designation.TESTER, Department.IT, 45000),
                new Employee(6, "Ganesh", Designation.MANAGER, Department.SALES, 70000),
                new Employee(7, "Dinesh", Designation.DEVELOPER, Department.MARKETING,
                        60000),
                new Employee(8, "Rakesh", Designation.TESTER, Department.IT, 50000),
                new Employee(10, "Vikram", Designation.DEVELOPER, Department.IT, 60000)
        };

        p.printArrayNewLine(list, "Before sort : ", false);

        Arrays.sort(list);

        p.printArrayNewLine(list, "After sort : ", false);

    }

    enum Designation {
        // IMP: enum compareTo uses ordinal of value that is sequence number
        DEVELOPER("Developer"), HR("HR"), MANAGER("Manager"), TESTER("Tester");

        private final String value;

        Designation(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

    enum Department {
        // enum compareTo uses ordinal of value that is sequence number
        IT("IT"), MARKETING("Marketing"), SALES("Sales"), HR("HR");

        private final String value;

        Department(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}

class Employee implements Comparable<Employee> {
    private int empno;
    private String name;
    private Designation designation;
    private Department department;
    private int salary;

    public Employee(int empno, String name, Designation designation, Department department, int salary) {
        this.empno = empno;
        this.name = name;
        this.designation = designation;
        this.department = department;
        this.salary = salary;
    }

    public int getEmpno() {
        return empno;
    }

    public String getName() {
        return name;
    }

    public Designation getDesignation() {
        return designation;
    }

    public Department getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public int compareTo(Employee other) {
        int diff = this.getDepartment().compareTo(other.getDepartment());
        if (diff == 0)
            diff = this.getDesignation().compareTo(other.getDesignation());
        if (diff == 0)
            diff = this.getSalary() - other.getSalary();
        return diff;
    }

    @Override
    public String toString() {
        return String.format("%-10d%-15s%-15s%-15s%-10d", empno, name, designation.getValue(), department.getValue(),
                salary);
    }

}
