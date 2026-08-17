package simpleInheritance;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee {

    private final static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private String name;
    private Double salary;
    private LocalDate birthDay;
    private Role role;

    public Employee() {
    }

    public Employee(String name, Double salary, LocalDate birthDay, Role role) {
        this.name = name;
        this.salary = salary;
        this.birthDay = birthDay;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Double totalSalary() {
        return salary;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append( " ").append(birthDay.format(fmt)).append (" ").append(role).append("\n");
        sb.append("Base salary: ").append(String.format("%.2f", salary)).append( "\n").append("Total salary of this mouth: ").append(String.format("%.2f", totalSalary()));

        return sb.toString();
    }




}
