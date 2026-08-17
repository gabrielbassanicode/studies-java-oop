package inheritance;

import java.time.LocalDate;

public class Manager extends Employee {

    private Double bonus;

    public Manager() {
        super();
    }

    public Manager(String name, Double salary, LocalDate birthDay, Double bonus, Role role) {
        super(name, salary, birthDay, role);
        this.bonus = bonus;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    @Override
    public Double totalSalary() {
        return getSalary() + bonus;

    }


}
