package org.vs.others.sort;


public class BubbleSortEmployee {

    public static void main(String[] args) {

        Employee[] employees = new Employee[]{
                Employee.of("Vishal", 15),
                Employee.of("Nishant", 4),
                Employee.of("Rajat", 12),
                Employee.of("Prashant", 18),
                Employee.of("Puri", 9)
        };

        int length = employees.length;
        int maxIndex = length - 1;

        for (int i = 0; i < maxIndex; i++) {
            for (int j = 0; j < maxIndex - i; j++) {
                if (employees[j].compareTo(employees[j + 1]) > -1) {
                    swap(employees, j, j + 1);
                }
            }

            print(employees);
        }
    }

    private static void print(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            System.out.print(employees[i] + " | ");
        }
        System.out.println();
    }

    private static void swap(Employee[] employees, int a, int b) {
        Employee temp = employees[a];
        employees[a] = employees[b];
        employees[b] = temp;
    }

}


class Employee implements Comparable {
    private String name;
    private Integer age;

    private Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static Employee of(String name, Integer age) {
        return new Employee(name, age);
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("Employee {name: %s, age: %d}", name, age);
    }

    @Override
    public int compareTo(Object obj) {
        if (obj != null && obj instanceof Employee) {
            Employee emp = (Employee) obj;
            return this.getAge().compareTo(((Employee) obj).getAge());
        }
        return -1;
    }
}