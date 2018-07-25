insert into student
values(1,'Dima', 'E1234567');

insert into student(id, NAME , passport_number)
values(2,'Sasha', 'A1234568');

-- insert into USER (ID, USERNAME, PASSWORD) values (1, 'avgdima@gmail.com', '$2a$04$uPbOwk0pmc3qU242IKU/cO/pASsSlHWsJXZ9fUmNMVADdbFrIHHyK');
INSERT INTO app_role (id, role_name, description) VALUES (1, 'STANDARD_USER', 'Standard User - Has no admin rights');
INSERT INTO app_role (id, role_name, description) VALUES (2, 'ADMIN_USER', 'Admin User - Has permission to perform admin tasks');

INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (1, 'John', 'Doe', '$2a$04$0qtQ0CmXcEB/q7h3MC/yHOjzdCu3XK9Fah399r6vVzDRa8jrLimkW', 'john.doe');
INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (2, 'Admin', 'Admin', '$2a$04$0qtQ0CmXcEB/q7h3MC/yHOjzdCu3XK9Fah399r6vVzDRa8jrLimkW', 'admin.admin');


INSERT INTO user_role(user_id, role_id) VALUES(1,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,2);
-- USER
-- non-encrypted password: 1990
