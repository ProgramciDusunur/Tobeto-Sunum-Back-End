CREATE TABLE IF NOT EXISTS `depo`.`stock` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(40) NOT NULL,
  `quantity` INT NOT NULL,
  `type_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `type_type_id_UNIQUE` (`type`, `type_id`)  -- type ve type_id birlikte benzersiz olmalı
) ENGINE = InnoDB;
