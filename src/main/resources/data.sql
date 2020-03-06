INSERT INTO user (username, firstname, lastname, password) VALUES ('Uncle_Bob', 'Bob', 'Martin','{bcrypt}$2a$10$WoG5Z4YN9Z37EWyNCkltyeFr6PtrSXSLMeFWOeDUwcanht5CIJgPa'); -- <1>
INSERT INTO user_roles (user_username,roles) VALUES ('Uncle_Bob', 'ROLE_USER'); -- <2>

INSERT INTO article (id, published_at, author_username, title, text) VALUES (1,'2015-12-01 08:00:00.0', 'Uncle_Bob' , 'A magnificent Article', 'Lorem ipsum dolor');
INSERT INTO article (id, published_at, author_username, title, text) VALUES (2, '2015-12-02 08:00:00.0', 'Uncle_Bob', 'Another Article', 'sit amet, consetetur sadipscing elitr');
