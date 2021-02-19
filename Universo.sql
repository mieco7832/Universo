drop database if exists `universo`;
create database `universo` charset utf8 collate utf8_spanish_ci;
use `universo`;

drop table if exists `galaxia`;
create table `galaxia`(
`id_galaxia` int auto_increment primary key,
`nombre` varchar(120),
`img` varchar(500),
`descripcion` varchar(300)
)engine innodb;


drop table if exists `planeta`;
create table `planeta`(
`id_planeta` int auto_increment primary key,
`nombre_planeta` varchar(120),
`masa` varchar(50),
`numero` int,
`img` varchar(500),
`galaxia` int,
`descripcion` varchar(300),
constraint fk_planeta_galaxia foreign key(`galaxia`) references `galaxia`(`id_galaxia`)
)engine innodb;