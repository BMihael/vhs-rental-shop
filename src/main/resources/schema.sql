DROP TABLE IF EXISTS VHS;
CREATE TABLE VHS
(
    id        NUMBER PRIMARY KEY AUTO_INCREMENT,
    name      VARCHAR(255)

);

DROP TABLE IF EXISTS RENTAL;
CREATE TABLE RENTAL
(
    id        NUMBER PRIMARY KEY AUTO_INCREMENT,
    orderDate DATE,
    endDate   DATE,
    vhsid     NUMBER,
    userid    NUMBER

);

DROP TABLE IF EXISTS USERS;
CREATE TABLE USERS
(
    user_id   NUMBER PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255),
    password  varchar(255),
    enabled   NUMBER
);

DROP TABLE IF EXISTS ROLES;
CREATE TABLE ROLES
(
    role_id   NUMBER PRIMARY KEY AUTO_INCREMENT,
    name  varchar(255),

);

DROP TABLE IF EXISTS USERS_ROLES;
CREATE TABLE `users_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  CONSTRAINT `role_fk` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`),
  CONSTRAINT `user_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
);