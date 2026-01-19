create table Roles(
id int Auto_INCREMENT ,
name Varchar(20) NOT NULL UNIQUE,
Primary key(id)
);

create table users
(
id BIGInt AUTO_INCREMENT,
name Varchar(25) NOT NULL,
email varchar(100) NOT NULL UNIQUE,
password varchar(255) NOT NULL,
role_id INT NOT NULL,
created_at timestamp DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (role_id) REFERENCES Roles(id),
primary key(id)
);


Create table Categories(
id BIGINT Auto_increment,
name Varchar(255),
type Varchar(30) NOT NULL,
Primary key(id)
); 

create table expense(
id BIGINT AUTO_INCREMENT,
user_id BIGINT NOT NULL,
Category_id BIGINT NOT NULL,
amount Decimal(10,2) NOT NULL,
description Varchar(255),
expense_date Date NOT NULL,
created_at TimeStamp Default Current_TIMESTAMP,
Primary key(id),

foreign key(user_id) References users(id) on Delete CASCADE,
Foreign key(Category_id) References categories(id)
);

alter table users MODIFY id BIGINT AUTO_INCREMENT;

drop table Categories;
drop table users;
drop table expenses;


INSERT INTO roles (name) VALUES ('ADMIN'), ('USER');

INSERT INTO users (name, email, password, role_id)
VALUES (
  'Admin',
  'admin@gmail.com',
  '$2a$10$xxxxxxxxxxxxxxxxxxxx', -- bcrypt of admin123
  1
);

