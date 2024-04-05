CREATE TABLE IF NOT EXISTS `depo`.`gpu` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `brand` VARCHAR(50) NOT NULL,
  `producer` VARCHAR(50) NOT NULL,
  `series` VARCHAR(50) NOT NULL,
  `model` VARCHAR(100) NOT NULL,
  `vram` INT NOT NULL,
  `memory_interface` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC)  
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;