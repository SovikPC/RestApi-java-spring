INSERT INTO role(name_role) values ('ROLE_USER'), ('ROLE_ADMIN');
INSERT INTO user(last_name, first_name, father_name, username, password, role_id, status) values ('Admin','Admin','Admin','admin','$2a$12$VPFlVsN3E2m7ChkxQo.haeNtMar/Hi38ucviMbPmz3nJjswkJnyT6',2,true);
Insert into status(status) values ('В работе'),('Не работает'),('На Списании'),('Списан')