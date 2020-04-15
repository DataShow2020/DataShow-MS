alter table station drop user_id;
alter table station add user_id varchar(50);
alter table operator drop user_name;
alter table operator add user_id varchar(50);