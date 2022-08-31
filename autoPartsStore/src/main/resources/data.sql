INSERT INTO users(id, name, role, money) VALUES('client1','Ivan Petrov','CLIENT', 2345);
INSERT INTO users(id, name, role, money) VALUES('client2','Kiril Dimitrov','CLIENT', 4980);
INSERT INTO users(id, name, role, money) VALUES('client3','Anna Petrova','CLIENT', 455);
INSERT INTO users(id, name, role, money) VALUES('client4','Mihail Kirilov','CLIENT', 200);
INSERT INTO users(id, name, role, money) VALUES('owner1','Angel Petrov','OWNER', 20000);
INSERT INTO users(id, name, role, money) VALUES('owner2','Miroslav Ivanov','OWNER', 80000);

INSERT INTO products(product_id, car_brand, price) VALUES('2234531FE','Reno', 34.00);
INSERT INTO products(product_id, car_brand, price) VALUES('2278779HG','Reno', 19.00);
INSERT INTO products(product_id, car_brand, price) VALUES('3475889JJ','Alfa', 54.00);
INSERT INTO products(product_id, car_brand, price) VALUES('5265378HH','Nissan', 124.00);
INSERT INTO products(product_id, car_brand, price) VALUES('3488689GD','Alfa', 28.00);
INSERT INTO products(product_id, car_brand, price) VALUES('3446689JO','Alfa', 164.00);
INSERT INTO products(product_id, car_brand, price) VALUES('6795378LH','BMW', 367.00);
INSERT INTO products(product_id, car_brand, price) VALUES('7866386TY','Audi', 898.00);
INSERT INTO products(product_id, car_brand, price) VALUES('5445537KH','Nissan', 24.00);
INSERT INTO products(product_id, car_brand, price) VALUES('3488989MD','Alfa', 283.00);
INSERT INTO products(product_id, car_brand, price) VALUES('3345668SO','Alfa', 46.00);
INSERT INTO products(product_id, car_brand, price) VALUES('6799178LP','BMW', 240.00);
INSERT INTO products(product_id, car_brand, price) VALUES('7806316FY','Audi', 90.00);

INSERT INTO storage(product_id, capacity, stock) VALUES('3475889JJ', 400, 20);

INSERT INTO shop(owner_id, storage_id, name, budget) VALUES('owner2', 1, 'Best Parts', 80000);

INSERT INTO orders(order_id, client_id, product_id, amount, price) VALUES('113344', 'client1','2234531FE', 1, 34.00);
INSERT INTO orders(order_id, client_id, product_id, amount, price) VALUES('114458', 'client2','3488689GD', 1, 28.00);
INSERT INTO orders(order_id, client_id, product_id, amount, price) VALUES('115553', 'client3','2234531FE', 1, 34.00);
INSERT INTO orders(order_id, client_id, product_id, amount, price) VALUES('113357', 'client1','2234531FE', 1, 34.00);
INSERT INTO orders(order_id, client_id, product_id, amount, price) VALUES('117744', 'client4','3488689GD', 1, 28.00);
INSERT INTO orders(order_id, client_id, product_id, amount, price) VALUES('114478', 'client4','5265378HH', 1, 124.00);