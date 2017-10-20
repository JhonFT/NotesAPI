/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Home
 * Created: 19-oct-2017
 */

CREATE TABLE users(
	use_code serial primary key,
	use_name varchar(30) not null,
	use_user varchar(30) not null unique, 
	use_pass varchar(30) not null,
	use_email varchar(60) not null unique
);

CREATE TABLE notes(
	not_code serial primary key,
	not_title varchar(30) not null,
	not_text varchar(30) not null unique, 
	not_fecreate timestamp default NOW(),
	not_feupdate varchar(60) not null unique,
	use_code integer not null,
	constraint fk_notes_usecode FOREIGN KEY  (use_code) REFERENCES  users(use_code)
);