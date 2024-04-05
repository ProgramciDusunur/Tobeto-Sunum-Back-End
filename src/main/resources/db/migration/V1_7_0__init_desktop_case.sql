CREATE TABLE IF NOT EXISTS `depo`.`desktop_case` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `brand` VARCHAR(50) NOT NULL,
  `model` VARCHAR(100) NOT NULL,
  `type` VARCHAR(50) NOT NULL,
  `psu` TINYINT NOT NULL, 
  `psu_location` VARCHAR(50) NOT NULL,
  `transparent` TINYINT NOT NULL, 
  `psu_watt` INT NOT NULL, 
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),  
  UNIQUE INDEX `model_UNIQUE` (`model` ASC)
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;