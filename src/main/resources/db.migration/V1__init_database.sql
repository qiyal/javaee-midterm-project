CREATE TABLE `javaee`.`book` (
    `book_id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NULL,
    `cost` INT NULL,
    `urlImage` VARCHAR(255) NULL,
    PRIMARY KEY (`book_id`)
);

CREATE TABLE `javaee`.`user` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `login` VARCHAR(255) NULL,
    `password` VARCHAR(255) NULL,
    `image_url` VARCHAR(255) NULL,
    PRIMARY KEY (`id`)
);
