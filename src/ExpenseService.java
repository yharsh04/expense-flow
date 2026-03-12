import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDate;

public class ExpenseService {

    public void addExpense(double amount, String category, String description) {

        String sql = "INSERT INTO expenses (user_id, amount, category, description, expense_date) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, 1); // temporarily using user_id = 1
            stmt.setDouble(2, amount);
            stmt.setString(3, category);
            stmt.setString(4, description);
            stmt.setDate(5, java.sql.Date.valueOf(LocalDate.now()));

            stmt.executeUpdate();
            System.out.println("Expense saved to database!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewExpenses() {

        String sql = "SELECT * FROM expenses";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("expense_id") +
                                " | Amount: " + rs.getDouble("amount") +
                                " | Category: " + rs.getString("category") +
                                " | Description: " + rs.getString("description") +
                                " | Date: " + rs.getDate("expense_date")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteExpense(int id) {

        String sql = "DELETE FROM expenses WHERE expense_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Expense deleted successfully!");
            } else {
                System.out.println("Expense not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateExpense(int id, double newAmount, String newCategory, String newDescription) {

        String sql = "UPDATE expenses SET amount = ?, category = ?, description = ? WHERE expense_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, newAmount);
            stmt.setString(2, newCategory);
            stmt.setString(3, newDescription);
            stmt.setInt(4, id);

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Expense updated successfully!");
            } else {
                System.out.println("Expense not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void monthlySummary() {

        String sql = "SELECT MONTHNAME(expense_date) AS month, SUM(amount) AS total " +
                "FROM expenses " +
                "GROUP BY MONTH(expense_date), MONTHNAME(expense_date) " +
                "ORDER BY MONTH(expense_date)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("Monthly Expense Summary:");

            while (rs.next()) {
                System.out.println("Month: " + rs.getString("month") +
                        " | Total: " + rs.getDouble("total"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}