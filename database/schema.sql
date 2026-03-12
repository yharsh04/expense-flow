CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE expenses (
    expense_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    amount DOUBLE,
    category VARCHAR(100),
    description VARCHAR(255),
    expense_date DATE,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);
