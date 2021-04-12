CREATE TABLE `javaee`.`order` (
    `order_id` INT NOT NULL AUTO_INCREMENT,
    `cost` INT NOT NULL,
    `user_id` INT NOT NULL,
    `order_day` DATE NOT NULL,
    PRIMARY KEY (`order_id`),
    INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
    CONSTRAINT `user_fk`
        FOREIGN KEY (`user_id`)
            REFERENCES `javaee`.`user` (`id`)
                ON DELETE NO ACTION
                ON UPDATE NO ACTION
);
