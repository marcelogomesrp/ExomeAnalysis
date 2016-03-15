INSERT INTO user (active, defaultProfile, email, password) VALUES (true, "administrator", "administrator@administrator.com", "123");
INSERT INTO user (active, defaultProfile, email, password) VALUES (true, "manager", "manager@manager.com", "123");
INSERT INTO user (active, defaultProfile, email, password) VALUES (true, "reviser", "reviser@reviser.com", "123");
INSERT INTO user (active, defaultProfile, email, password) VALUES (true, "manager", "managerreviser@reviser.com", "123");

INSERT INTO user_profiles (User_id, profiles) VALUES (1,"administrator" );
INSERT INTO user_profiles (User_id, profiles) VALUES (2,"manager" );
INSERT INTO user_profiles (User_id, profiles) VALUES (3,"reviser" );
INSERT INTO user_profiles (User_id, profiles) VALUES (4,"administrator" );
INSERT INTO user_profiles (User_id, profiles) VALUES (4,"reviser" );


INSERT INTO project (name,projectState,manager_id) VALUES ("Primeiro","processed",2);
INSERT INTO project (name,projectState,manager_id) VALUES ("Segundo","processed",2);
INSERT INTO project (name,projectState,manager_id) VALUES ("Terceiro","processed",2);
INSERT INTO project (name,projectState,manager_id) VALUES ("Primeiro","uploaded",2);


INSERT INTO variant (project_id,position,selected) VALUES (1,"1",false);
INSERT INTO variant (project_id,position,selected) VALUES (1,"11",false);
INSERT INTO variant (project_id,position,selected) VALUES (1,"111",true);
INSERT INTO variant (project_id,position,selected) VALUES (1,"1111",true);
INSERT INTO variant (project_id,position,selected) VALUES (1,"11111",true)
INSERT INTO variant (project_id,position,selected) VALUES (1,"111111",false);

INSERT INTO variant (project_id,position,selected) VALUES (2,"B",false);
INSERT INTO variant (project_id,position,selected) VALUES (2,"BB",false);
INSERT INTO variant (project_id,position,selected) VALUES (2,"BBB",true);
INSERT INTO variant (project_id,position,selected) VALUES (2,"BBBB",true);
INSERT INTO variant (project_id,position,selected) VALUES (2,"BBBBB",true)
INSERT INTO variant (project_id,position,selected) VALUES (2,"BBBBBB",false);

INSERT INTO project_user (listProjectsReviser_id, listRevisers_id) VALUES (1,1);