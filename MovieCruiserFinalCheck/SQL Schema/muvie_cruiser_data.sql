/*Movie Table Details*/

INSERT INTO `movie_cruiser`.`movie` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('1', 'Avatar', '2787965087', '1', '2019-03-15', 'Science Fiction', '1');
INSERT INTO `movie_cruiser`.`movie` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('2', 'The Avengers', '1518812988', '1', '2018-12-23', 'Superhero', '0');
INSERT INTO `movie_cruiser`.`movie` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('3', 'Titanic', '2187463944', '1', '2020-01-06', 'Romance', '0');
INSERT INTO `movie_cruiser`.`movie` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('4', 'Jurassic World', '1671713208', '0', '2022-11-27', 'Science Fiction', '1');
INSERT INTO `movie_cruiser`.`movie` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('5', 'Avengers:End Game', '2750760348', '1', '2021-05-22', 'Superhero', '1');

/*User Table Details*/

insert into `movie_cruiser`.`user`(`us_id`,`us_name`) values('1','Pranjali');
insert into `movie_cruiser`.`user`(`us_id`,`us_name`) values('2','Ashwini');

/*Favorite Table Details*/

insert into `movie_cruiser`.`favorite`(`fav_id`,`fav_us_id`,`fav_mo_id`) values('1','1','1');
insert into `movie_cruiser`.`favorite`(`fav_id`,`fav_us_id`,`fav_mo_id`) values('2','1','3');
insert into `movie_cruiser`.`favorite`(`fav_id`,`fav_us_id`,`fav_mo_id`) values('3','1','5');

/*1. View Movie List Admin (TYUC001)*/

select mo_id,
mo_title,
mo_box_office,
mo_active,
mo_date_of_launch,
mo_genre,
mo_has_teaser
from 
movie_cruiser.movie;

/*2. View Movie List Customer (TYUC002)*/

select  mo_id,
mo_title,
mo_box_office,
mo_active,
mo_date_of_launch,
mo_genre,
mo_has_teaser
from 
movie_cruiser.movie 
where mo_active='1' and mo_date_of_launch > (select CURDATE());

/*3. Edit Movie (TYUC003)*/

select mo_id,
mo_title,
mo_box_office,
mo_active,
mo_date_of_launch,
mo_genre,
mo_has_teaser from movie_cruiser.movie where mo_id='1';

/*Update Movie*/

update movie_cruiser.movie set mo_id='1',
mo_title='Dabang 3',
mo_box_office='5555555555',
mo_active='1',
mo_date_of_launch='2019-11-25',
mo_genre='Thriller',
mo_has_teaser='0' 
where 
mo_id='1';

/*4. Add to Favorite (TYUC004)*/

insert into movie_cruiser.favorite(`fav_us_id`,`fav_mo_id`) values(1,1);
insert into movie_cruiser.favorite(`fav_us_id`,`fav_mo_id`) values(1,3);
insert into movie_cruiser.favorite(`fav_us_id`,`fav_mo_id`) values(1,5);

/*5. View Favorite (TYUC005)*/

select mo_title,
mo_box_office,
mo_active,
mo_date_of_launch,
mo_genre,
mo_has_teaser from movie_cruiser.movie
inner join movie_cruiser.favorite on fav_mo_id=mo_id
where fav_us_id=1;

/*Favorite count*/

select count(movie_cruiser.favorite.fav_id) as Favorite_count
from movie_cruiser.favorite;

/*6. Remove Item from Favorite(TYUC006)*/

delete from movie_cruiser.favorite where fav_us_id=1 and fav_mo_id=1 limit 1;

select fav_id,
fav_us_id,
fav_mo_id 
from 
movie_cruiser.favorite;



