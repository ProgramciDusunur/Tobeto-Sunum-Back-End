CREATE TABLE IF NOT EXISTS `depo`.`stock` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(40) NOT NULL,
  `quantity` INT NOT NULL,
  `type_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC)
) ENGINE = InnoDB;