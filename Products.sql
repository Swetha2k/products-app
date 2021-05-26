create table product_2591(id number,name varchar(200),expiry_date date);
insert into product_2591 values(1,'Pen',DATE '2023-01-01');
insert into product_2591 values(2,'Pencil',DATE '2023-01-08');
insert into product_2591 values(3,'Milk',DATE '2023-01-07');
commit;
select * from product_2591;