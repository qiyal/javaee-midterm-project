CREATE TABLE `order_item` (
                                        `order_item_id` INT NOT NULL AUTO_INCREMENT,
                                        `book_id` INT NULL,
                                        `order_id` INT NULL,
                                        PRIMARY KEY (`order_item_id`),
                                        INDEX `fk1_book_id_idx` (`book_id` ASC) VISIBLE,
                                        INDEX `fk2_order_id_idx` (`order_id` ASC) VISIBLE,
                                        CONSTRAINT `fk1_book_id`
                                            FOREIGN KEY (`book_id`)
                                                REFERENCES `book` (`book_id`)
                                                ON DELETE NO ACTION
                                                ON UPDATE NO ACTION,
                                        CONSTRAINT `fk2_order_id`
                                            FOREIGN KEY (`order_id`)
                                                REFERENCES `order` (`order_id`)
                                                ON DELETE NO ACTION
                                                ON UPDATE NO ACTION);
