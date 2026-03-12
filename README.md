# ExpenseFlow

ExpenseFlow is a backend expense management system built using **Java, JDBC, and MySQL**.  
The application allows users to add, view, update, and delete expenses while storing data in a relational database.

This project demonstrates **CRUD operations, database connectivity using JDBC, and SQL aggregation queries**.

---

## Tech Stack

- Java
- JDBC
- MySQL

---

## Features

- Add Expense
- View Expenses
- Update Expense
- Delete Expense
- Monthly Expense Summary

---

## Architecture

User Input (Console)  
⬇  
Main.java (Application Entry Point)  
⬇  
ExpenseService.java (Business Logic Layer)  
⬇  
JDBC  
⬇  
MySQL Database  

---

## Project Structure


expense-flow
├── src
│ ├── DBConnection.java
│ ├── Expense.java
│ ├── ExpenseService.java
│ └── Main.java
├── database
│ └── schema.sql
└── README.md


---

## Database Design

### users table

| Column | Type | Description |
|------|------|-------------|
| user_id | INT | Primary Key |

### expenses table

| Column | Type | Description |
|------|------|-------------|
| expense_id | INT | Primary Key |
| user_id | INT | Foreign Key referencing users |
| amount | DOUBLE | Expense amount |
| category | VARCHAR | Expense category |
| description | VARCHAR | Description of expense |
| expense_date | DATE | Date of expense |

---

## Database Setup

Run the SQL script located in:


database/schema.sql


This will create the required tables.

---

## How to Run

1. Install MySQL
2. Create a database named:


expense_manager


3. Update database credentials in:


DBConnection.java


Example:

```java
private static final String URL = "jdbc:mysql://localhost:3306/expense_manager";
private static final String USER = "root";
private static final String PASSWORD = "your_password";

Run the application:

Main.java
Demo

Example console interaction:

1. Add Expense
2. View Expenses
3. Delete Expense
4. Update Expense
5. Monthly Summary
6. Exit

Choose option: 1

Enter amount: 250
Enter category: Food
Enter description: Lunch

Expense saved to database!

Choose option: 2

ID: 1 | Amount: 250 | Category: Food | Description: Lunch | Date: 2026-03-12
Author

Harsh Yadav
