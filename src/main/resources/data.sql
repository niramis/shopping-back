INSERT INTO address(city,country,state,zip) VALUES ('city1','country1','state1','zip1');
INSERT INTO address(city,country,state,zip) VALUES ('city2','country2','state2','zip2');
INSERT INTO address(city,country,state,zip) VALUES ('city3','country3','state3','zip3');
INSERT INTO address(city,country,state,zip) VALUES ('city4','country4','state4','zip4');

INSERT INTO category(description,name) VALUES ('description1','name1');
INSERT INTO category(description,name) VALUES ('description2','name2');
INSERT INTO category(description,name) VALUES ('description3','name3');
INSERT INTO category(description,name) VALUES ('description4','name4');

INSERT INTO product(description, name, price) VALUES ('description1','name1', 22.2);
INSERT INTO product(description, name, price) VALUES ('description2','name2', 11.1);


INSERT INTO product_categories(product_id,category_id) VALUES (1,1);
INSERT INTO product_categories(product_id,category_id) VALUES (1,3);
INSERT INTO product_categories(product_id,category_id) VALUES (2,2);
INSERT INTO product_categories(product_id,category_id) VALUES (2,3);

INSERT INTO user(password,role,username,address_id) VALUES ('$2a$10$qfWGlIR0aq1iVIHxCcVsQekftm2DEx2z73lRDzWUQWhiY6y9mD6Pm','ADMIN','admin',1);
INSERT INTO user(password,role,username,address_id) VALUES ('$2a$10$mErHaVpPqoY6Kftklw/1DOnndA8FTx8HUiOcnp7eGSeBUaz6fF/i.','USER','user1',2);
INSERT INTO user(password,role,username,address_id) VALUES ('$2a$10$UnOXvDIW2dos9iueTKH5vOGsXzV4HtdiI7D52LiOedXB0y0av3ebK','USER','user2',3);
INSERT INTO user(password,role,username,address_id) VALUES ('$2a$10$ExWpOo0igpY4Oceg9rXdLOxxOvFnVBl0WVYSLhKiXnXW66B1tCbNG','USER','user3',4);

INSERT INTO orders(order_status,user_id) VALUES ('STATE1',1);
INSERT INTO orders(order_status,user_id) VALUES ('STATE1',2);
INSERT INTO orders(order_status,user_id) VALUES ('STATE1',3);

--INSERT INTO order_details(quantity,order_id,product_id) VALUES (3,1,1);
--INSERT INTO order_details(quantity,order_id,product_id) VALUES (2,1,2);
--INSERT INTO order_details(quantity,order_id,product_id) VALUES (1,2,1);
--INSERT INTO order_details(quantity,order_id,product_id) VALUES (5,2,2);
--
--INSERT INTO order_details(quantity,order_id,product_id) VALUES (6,3,1);
--INSERT INTO order_details(quantity,order_id,product_id) VALUES (2,3,2);

--INSERT INTO order_products(order_id,product_id) VALUES (1,1);
--INSERT INTO order_products(order_id,product_id) VALUES (1,2);
--INSERT INTO order_products(order_id,product_id) VALUES (1,2);

