package com.damelyngdoh.codemine.nthlargestelementstream;

import java.util.ArrayList;
import java.util.List;

public class NthLargestElelement {
    
    public static void main(String[] args) {
        
        final int nth = 2;
        List<Employee> employees = new ArrayList<>();
        
        employees.add(new Employee(1, 1000, "Sam"));
        employees.add(new Employee(2, 900, "Peter"));
        employees.add(new Employee(3, 1100, "Heather"));
        employees.add(new Employee(4, 800, "Crangis"));

        Employee second = employees.stream()
            .sorted((emp1,emp2) -> {
                if(emp1.getSalary() > emp2.getSalary())
                    return -1;
                if(emp1.getSalary() < emp2.getSalary())
                    return 1;
                return 0;
            })
            .skip(nth)
            .findFirst().get();

        System.out.println(second);
    }

    static class Employee {
        private int id;
        private int salary;
        private String name;

        public Employee(int id, int salary, String name) {
            this.id = id;
            this.salary = salary;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getSalary() {
            return salary;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return String.format("ID=%d   Salary=%d    Name=%s", id, salary, name);
        }
    }
}
