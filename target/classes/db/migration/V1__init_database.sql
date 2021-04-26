CREATE TABLE `user` (
    `user_id` INT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `name` VARCHAR(255) NULL,
    `url_image` VARCHAR(255) NULL,
    PRIMARY KEY (`user_id`),
    UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE);

CREATE TABLE `book` (
    `book_id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NULL,
    `cost` INT NULL,
    `url_image` VARCHAR(255) NULL,
    PRIMARY KEY (`book_id`));

CREATE TABLE `order` (
    `order_id` INT NOT NULL AUTO_INCREMENT,
    `user_id` INT NULL,
    `cost` DOUBLE NULL,
    `order_day` DATE NULL,
    PRIMARY KEY (`order_id`),
    INDEX `fk1_user_id_idx` (`user_id` ASC) VISIBLE,
    CONSTRAINT `fk1_user_id`
        FOREIGN KEY (`user_id`)
        REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


