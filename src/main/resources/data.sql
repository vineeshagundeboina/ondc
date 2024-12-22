INSERT INTO public.t_role (id,created_at,created_by,is_active,updated_at,updated_by,description,"name") VALUES
	 ('7f000001-8303-1c9a-8183-03729e470002','2022-09-03 18:33:06.823',NULL,true,'2022-09-03 18:33:06.823',NULL,'Manager','Manager');
INSERT INTO public.t_role (id,created_at,created_by,is_active,updated_at,updated_by,description,"name") VALUES
	 ('7f000001-8303-1c9a-8183-03729e470001','2022-09-03 18:33:06.823',NULL,true,'2022-09-03 18:33:06.823',NULL,'Employee','Employee');
INSERT INTO public.t_role (id,created_at,created_by,is_active,updated_at,updated_by,description,"name") VALUES
	 ('7f000001-8303-1c9a-8183-03729e470000','2022-09-03 18:33:06.823',NULL,true,'2022-09-03 18:33:06.823',NULL,'Super Adminiotrator','SuperAdmin');



INSERT INTO public.t_user(id, created_at, created_by, is_active, updated_at, updated_by, activation_token,delete_allowed, email, email_token_expiry_date, email_verified, employee_id, employee_name, mobile_number, mobile_verified, mpin, "password", reset_token, reset_token_expiry_date, user_name)  VALUES
	 ('7f000001-8303-12b2-8183-034914600000','2022-09-03 17:47:44.544',NULL,true,'2022-09-03 17:49:40.820',NULL,NULL,false,NULL,'2022-09-03 17:47:44.544',true,'SSPL140','Ramesh','9000784494',true,null,'$2a$10$n3ZEz0XgHXNWWsznqUIWI.3QHALKjX60PiMhnMuOCO3EadXIYGJZC',null,'2022-09-03 17:47:44.544','9000784494');


INSERT INTO public.t_users_roles (user_id,role_id) VALUES
	 ('7f000001-8303-12b2-8183-034914600000','7f000001-8303-1c9a-8183-03729e470000');
	 
CREATE sequence PO_SEQ increment by 1 start with 1000001;

