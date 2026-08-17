package simpleInheritance;

import java.time.LocalDate;

public class Developer extends Employee {

    Integer completedProjects;

    public Developer() {
        super();
    }

    public Developer(String name, Double salary, LocalDate birthDay, Integer completedProjects, Role role)  {
        super(name, salary, birthDay,role);
        this.completedProjects = completedProjects;
    }

    public Integer getCompletedProjects() {
        return completedProjects;
    }

    public void setCompletedProjects(Integer completedProjects) {
        this.completedProjects = completedProjects;
    }

    @Override
    public Double totalSalary() {
        return getSalary() + completedProjects * 500;

    }
}
