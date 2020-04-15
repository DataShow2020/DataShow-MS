# alter table vehicle drop driver_name;
# alter table vehicle drop driver_phone;
# alter table vehicle drop card_id;
# DROP TABLE IF EXISTS `driver`;
# create table `driver` (
#     `name` VARCHAR(10) not null,
#     `phone` VARCHAR(11) not null,
#     `card_id` VARCHAR(19) not null,
#     `sex` VARCHAR(2) not null,
#     `age` int(3) not null,
#     PRIMARY KEY (`card_id`)
# )ENGINE=InnoDB DEFAULT CHARSET=utf8;
# DROP TABLE IF EXISTS `driver`;
create table `operator` (
    `id` VARCHAR(10),
    `distribution_id` VARCHAR(10),
    `user_name` VARCHAR(11),
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;