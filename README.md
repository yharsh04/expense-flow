# ExpenseFlow

ExpenseFlow is a backend expense management system built using Java, JDBC, and MySQL.

The application allows users to add, view, update, and delete expenses while storing data in a relational database.

## Tech Stack
- Java
- JDBC
- MySQL

## Features
- Add Expense
- View Expenses
- Update Expense
- Delete Expense
- Monthly Expense Summary

## Architecture
Console Input → Main.java → ExpenseService → JDBC → MySQL Database

## Database Design

users table  
- user_id (Primary Key)

expenses table  
- expense_id (Primary Key)
- user_id (Foreign Key)
- amount
- category
- description
- expense_date

## How to Run
1. Install MySQL
2. Create database `expense_manager`
3. Update database credentials in `DBConnection.java`
4. Run `Main.java`

## Author
Harsh Yadav
