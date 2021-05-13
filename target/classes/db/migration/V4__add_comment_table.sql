CREATE TABLE `javaee2`.`comment` (
  `comment_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL,
  `book_id` INT NULL,
  `text` VARCHAR(255) NULL,
  PRIMARY KEY (`comment_id`),
  INDEX `fk1_u_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk2_b_idx` (`book_id` ASC) VISIBLE,
  CONSTRAINT `fk1_u`
    FOREIGN KEY (`user_id`)
    REFERENCES `javaee2`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk2_b`
    FOREIGN KEY (`book_id`)
    REFERENCES `javaee2`.`book` (`book_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
