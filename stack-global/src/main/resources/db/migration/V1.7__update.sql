alter table order_staion_relation drop station_name;
alter table order_staion_relation drop next_station_name;
alter table order_staion_relation add station_id VARCHAR(50);
alter table order_staion_relation add next_station_id VARCHAR(50);
alter table operator drop distribution_id;
alter table operator add station_id VARCHAR(50);
DROP table courier;