CREATE TABLE IF NOT EXISTS `depo`.`shelf` (
  `id` INT AUTO_INCREMENT,
  `occupied_quantity` INT NOT NULL,
  `stock_id` INT,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB;