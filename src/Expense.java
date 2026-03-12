public class Expense {
    int id;
    double amount;
    String category;
    String description;

    public Expense(int id, double amount, String category, String description) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.description = description;
    }
}