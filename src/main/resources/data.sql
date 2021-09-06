INSERT INTO VHS (name) VALUES ('Avengers');
INSERT INTO VHS (name) VALUES ('Avengers Age of Ultron');
INSERT INTO VHS (name) VALUES ('Avengers Infinity War');
INSERT INTO VHS (name) VALUES ('Avengers Endgame');

INSERT INTO RENTAL (orderDate, endDate, vhsid, userid) VALUES (CURRENT_DATE(), CURRENT_DATE() +10, 1, 2);

INSERT INTO `roles` (`name`) VALUES ('ROLE_ADMIN');
INSERT INTO `roles` (`name`) VALUES ('ROLE_USER');

INSERT INTO `users` (`username`, `password`, `enabled`) VALUES ('miha', '$2a$12$rSmZsoZVbtDSaU3EnZKUGusMSMoeSgdPDwobuoyBZdeK.cTqi6Gbi', '1');
INSERT INTO `users` (`username`, `password`, `enabled`) VALUES ('belko', '$2a$12$REIGPEtclR1T2B4TmrskeO.CaGKX54foY9IqtmXvJ4D08QNzVHMna', '1');

INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (1, 1); -- user miha has role ADMIN
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (2, 2); -- user belko has role USER
