CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255), cost int , PRIMARY KEY (id));

INSERT INTO products (title, cost)
VALUES
('Eggs', 50),
('Milk', 40),
('Bread', 30),
('Chicken', 100),
('Duck', 130);