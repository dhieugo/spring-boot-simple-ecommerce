insert into brands(id, brand_name) values (1, 'BMW'),(2, 'Audi'), (3, 'Mercedes-Benz');

insert into categories(id, category_name) values (1, 'Sedan'), (2, 'Coupe'), (3, 'Convertible'), (4, 'Minivan'), (5, 'Sport Car');

insert into products(id, brand_id, category_id, product_name, product_slug, sku, price) values (1, 1, 1, 'BMW M5', 'sport,nice', 'BM5SN', 50000);
insert into products(id, brand_id, category_id, product_name, product_slug, sku, price) values (2, 2, 5, 'R8', 'sport,cool', 'AR8SC', 60000);
insert into products(id, brand_id, category_id, product_name, product_slug, sku, price) values (3, 3, 2, 'CLS Coupe', 'sport,cool', 'MCLSCSC', 55000);
insert into products(id, brand_id, category_id, product_name, product_slug, sku, price) values (4, 3, 1, 'Toyota Camry', 'ok', 'TOYOTACAM', 35000);

insert into product_attributes(id, product_id, attribute_name, attribute_value) values (1, 1, 'COLOR', 'Red');
insert into product_attributes(id, product_id, attribute_name, attribute_value) values (2, 1, 'COLOR', 'Blue');
insert into product_attributes(id, product_id, attribute_name, attribute_value) values (3, 2, 'COLOR', 'Green');
insert into product_attributes(id, product_id, attribute_name, attribute_value) values (4, 2, 'COLOR', 'Yellow');
insert into product_attributes(id, product_id, attribute_name, attribute_value) values (5, 3, 'COLOR', 'Black');
insert into product_attributes(id, product_id, attribute_name, attribute_value) values (6, 3, 'COLOR', 'Diamond White');
insert into product_attributes(id, product_id, attribute_name, attribute_value) values (7, 4, 'COLOR', 'Diamond');