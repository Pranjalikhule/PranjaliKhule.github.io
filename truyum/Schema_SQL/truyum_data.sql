/*Menu_item Table Details*/

INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('1', 'Sandwich', '99', '1', '2019-04-23', 'Main Course', '1');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('2', 'Burger', '129', '1', '2019-12-23', 'Main Course', '0');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('3', 'Pizza', '149', '1', '2020-01-10', 'Main Course', '0');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('4', 'French Fries', '57', '0', '2021-01-01', 'Starters', '1');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('5', 'Chocolate Brownies', '32', '1', '2022-11-02', 'Dessert', '1');

/*User Table Details*/

insert into `truyum`.`user`(us_id,us_name) values(1,'Siva');
insert into `truyum`.`user`(us_id,us_name) values(2,'Ajay');

/*Cart Table Details*/

insert into `truyum`.`cart`(ct_us_id,ct_me_id) values(1,1);
insert into `truyum`.`cart`(ct_us_id,ct_me_id) values(1,3);
insert into `truyum`.`cart`(ct_us_id,ct_me_id) values(1,5);

/*1. View Menu Item List Admin (TYUC001)*/

select me_id,
me_name,
me_price,
me_active,
me_date_of_launch,
me_category,
me_free_delivery
from 
truyum.menu_item;

/*2. View Menu Item List Customer (TYUC002)*/

select me_id,
me_name,
me_price,
me_active,
me_date_of_launch,
me_category,
me_free_delivery
from truyum.menu_item where 
me_active='1' and me_date_of_launch > (select CURDATE());

/*3. Edit Menu Item (TYUC003)*/

select me_id,
me_name,
me_price,
me_active,
me_date_of_launch,
me_category,
me_free_delivery
from 
truyum.menu_item 
where 
cartme_id='1';

/*Update menu_item*/

update menu_item set me_name='Puran Poli',
me_price='100',
me_active='1',
me_date_of_launch='2020-02-02',
me_category='Main Course',
me_free_delivery='0' 
where
me_id='1';

/*4. Add to Cart (TYUC004)*/

insert into `truyum`.`cart`(`ct_us_id`,`ct_me_id`) values (1,1);
insert into `truyum`.`cart`(`ct_us_id`,`ct_me_id`) values (1,3);
insert into `truyum`.`cart`(`ct_us_id`,`ct_me_id`) values (1,5);

/*5. View Cart (TYUC005)*/

select me_name,
me_price,me_active,
me_date_of_launch,
me_category,
me_free_delivery from truyum.menu_item
inner join  truyum.cart on  ct_me_id=me_id 
where ct_us_id=1;

select sum(me_price)as Total 
from truyum.menu_item
inner join  truyum.cart on  ct_me_id=me_id;

/*6. Remove Item from Cart (TYUC006)*/

delete from truyum.cart 
where ct_us_id=1 and ct_me_id=1 limit 1;

select ct_id,
ct_us_id,
ct_me_id
from 
truyum.cart;
