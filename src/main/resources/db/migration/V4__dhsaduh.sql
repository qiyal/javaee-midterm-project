CREATE TABLE `nico` (
                        `user_id` INT NOT NULL AUTO_INCREMENT,
                        `username` VARCHAR(255) NOT NULL,
                        `password` VARCHAR(255) NOT NULL,
                        `name` VARCHAR(255) NULL,
                        `url_image` VARCHAR(255) NULL,
                        PRIMARY KEY (`user_id`),
                        UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE);


