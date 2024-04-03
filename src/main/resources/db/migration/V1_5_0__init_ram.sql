CREATE TABLE IF NOT EXISTS `depo`.`ram` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(50) NOT NULL,
  `capacity` INT NOT NULL,
  `frequency_speed` INT NOT NULL,
  `channel_type` VARCHAR(50) NOT NULL,
  `compatibility` VARCHAR(50) NOT NULL,
  `brand` VARCHAR(45) NOT NULL,
  `model` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),  
  UNIQUE INDEX `model_UNIQUE` (`model` ASC)
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;