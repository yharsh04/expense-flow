import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ExpenseService service = new ExpenseService();

    public static void main(String[] args) {
        try {
            System.out.println("Connecting to database...");
            DBConnection.getConnection();
            System.out.println("Connected successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        while (true) {
            System.out.println("\n1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. Update Expense");
            System.out.println("5. Monthly Summary");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter description: ");
                    String description = sc.nextLine();

                    service.addExpense(amount, category, description);
                    break;

                case 2:
                    service.viewExpenses();
                    break;

                case 3:
                    System.out.print("Enter expense ID to delete: ");
                    int id = sc.nextInt();
                    service.deleteExpense(id);
                    break;

                case 4:
                    System.out.print("Enter expense ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new amount: ");
                    double newAmount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter new category: ");
                    String newCategory = sc.nextLine();

                    System.out.print("Enter new description: ");
                    String newDescription = sc.nextLine();

                    service.updateExpense(updateId, newAmount, newCategory, newDescription);
                    break;

                case 5:
                    service.monthlySummary();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}