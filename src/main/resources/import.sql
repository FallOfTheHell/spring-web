DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE IF NOT EXISTS products (id bigserial, cost int, title VARCHAR(255), PRIMARY KEY (id));
INSERT INTO products (title, cost) VALUES ('Eggs', 20), ('Milk', 40), ('Bread', 30);


DROP TABLE IF EXISTS clients CASCADE;
CREATE TABLE clients (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO clients (name) VALUES ('Alexander'), ('Bob');


DROP TABLE IF EXISTS products_clients CASCADE;
CREATE TABLE products_clients (product_id bigint, client_id bigint, FOREIGN KEY (product_id) REFERENCES products (id), FOREIGN KEY (client_id) REFERENCES clients (id));
INSERT INTO products_clients (product_id, client_id) VALUES (1, 1),(2, 1),(3, 1),(3, 2),(2, 2),(1, 2);