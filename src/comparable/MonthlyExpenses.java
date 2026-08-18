package comparable;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MonthlyExpenses {

    private final static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final static DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("MM/yyyy");
    private YearMonth date;
    private List<Expense> expenses = new ArrayList<>();

    public MonthlyExpenses(YearMonth date) {
        this.date = date;
    }

    public YearMonth getDate() {
        return date;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setDate(YearMonth date) {
        this.date = date;
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);

    }

    public void removeExpense(Expense expense) {
        expenses.remove(expense);

    }

    public Double total() {

        double sum = 0.0;
        for (Expense e: expenses) {
            sum += e.getValue();
        }
        return sum;
    }

    @Override
    public String toString() {

        // Makes a copy of the list and sort to protect the original list

        StringBuilder sb = new StringBuilder();
        List<Expense> sortedExpenses = new ArrayList<>(expenses);
        Collections.sort(sortedExpenses);

        sb.append("Mouth: ").append(date.format(fmt2)).append("\n");
        for (Expense e: sortedExpenses) {
            sb.append(e.getName()).append(": ").append(String.format("%.2f", e.getValue())).append(" - ")
                    .append(e.getExpenseDate().format(fmt)).append("\n");

        }
        sb.append("Total: ").append(String.format("%.2f", total()));
        return sb.toString();

    }

}
