# ExpenseFlow

ExpenseFlow is a console-based expense management system built using **Java, JDBC, and MySQL**.
It allows users to manage expenses by performing CRUD operations and storing the data in a MySQL database.

---

## Tech Stack

* Java
* JDBC
* MySQL

---

## Features

* Add Expense
* View Expenses
* Update Expense
* Delete Expense
* Monthly Expense Summary

---

## Project Structure

```
expense-flow
│
├── src
│   ├── DBConnection.java
│   ├── Expense.java
│   ├── ExpenseService.java
│   └── Main.java
│
├── database
│   └── schema.sql
│
└── README.md
```

---

## Database Schema

### Users Table

| Column  | Type              |
| ------- | ----------------- |
| user_id | INT (Primary Key) |

### Expenses Table

| Column       | Type              |
| ------------ | ----------------- |
| expense_id   | INT (Primary Key) |
| user_id      | INT (Foreign Key) |
| amount       | DOUBLE            |
| category     | VARCHAR           |
| description  | VARCHAR           |
| expense_date | DATE              |

---

## Database Setup

1. Install MySQL
2. Create a database:

```
CREATE DATABASE expense_manager;
```

3. Run the SQL script:

```
database/schema.sql
```

4. Update database credentials in **DBConnection.java**

Example:

```java
private static final String URL = "jdbc:mysql://localhost:3306/expense_manager";
private static final String USER = "root";
private static final String PASSWORD = "your_password";
```

---

## Running the Application

Run the application using:

```
Main.java
```

---

## Example Console Interaction

```
1. Add Expense
2. View Expenses
3. Update Expense
4. Delete Expense
5. Monthly Summary
6. Exit

Choose option: 1
Enter amount: 250
Enter category: Food
Enter description: Lunch
Expense saved successfully!

Choose option: 1
Enter amount: 1200
Enter category: Transport
Enter description: Bus Pass
Expense saved successfully!

Choose option: 2
ID: 1 | Amount: 250 | Category: Food | Description: Lunch | Date: 2026-03-12
ID: 2 | Amount: 1200 | Category: Transport | Description: Bus Pass | Date: 2026-03-12

Choose option: 5
Monthly Expense Summary
Total Expenses: 1450
```

---

## Author

Harsh Yadav
