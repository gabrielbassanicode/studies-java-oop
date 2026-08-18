package polymorphism;

public class LegalEntity extends Person {

    private Integer numberOfEmployees;

    public LegalEntity() {
        super();
    }

    public LegalEntity(String name, Double annualIncome, Integer numberOfEmployees) {
        super(name, annualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public Double taxCalculation() {
        double tax;

        if (numberOfEmployees < 10) {
            tax = 0.16;

        }else {
            tax = 0.14;
        }
        return getAnnualIncome() * tax;

    }
}
