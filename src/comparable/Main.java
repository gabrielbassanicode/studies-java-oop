package comparable;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Hardcoded

        MonthlyExpenses monthlyExpenses = new MonthlyExpenses(YearMonth.parse("08/2026", fmt));

        Expense expense1 = new Expense(LocalDate.parse("08/08/2026", fmt2), 1250.00, "Car maintenance");
        monthlyExpenses.getExpenses().add(expense1);

        Expense expense2 = new Expense(LocalDate.parse("01/08/2026", fmt2), 600.00, "Family trip");
        monthlyExpenses.getExpenses().add(expense2);

        Expense expense3 = new Expense(LocalDate.parse("26/08/2026", fmt2), 500.00, "New table for the room");
        monthlyExpenses.getExpenses().add(expense3);

        Expense expense4 = new Expense(LocalDate.parse("12/08/2026", fmt2), 35.00, "Streaming services");
        monthlyExpenses.getExpenses().add(expense4);

        // Get the list ordered by date

        System.out.println(monthlyExpenses);

    }

}
