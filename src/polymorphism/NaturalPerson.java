package polymorphism;

public class NaturalPerson extends Person {

    private Double medicalExpenses;

    public NaturalPerson() {
        super();
    }

    public NaturalPerson(String name, Double annualIncome, Double medicalExpenses) {
        super(name, annualIncome);
        this.medicalExpenses = medicalExpenses;
    }

    public Double getMedicalExpenses() {
        return medicalExpenses;
    }

    public void setMedicalExpenses(Double medicalExpenses) {
        this.medicalExpenses = medicalExpenses;
    }

    @Override
    public Double taxCalculation() {
        double tax;

        if (getAnnualIncome() < 20000.00) {
            tax = 0.15;

        }else {
            tax = 0.25;

        }
        if (medicalExpenses > 0) {
            return (getAnnualIncome() * tax) - (medicalExpenses * 0.5);

        }else {
            return getAnnualIncome() * tax;

        }
    }
}
