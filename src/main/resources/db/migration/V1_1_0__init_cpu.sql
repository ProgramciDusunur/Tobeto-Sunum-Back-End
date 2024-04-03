CREATE TABLE IF NOT EXISTS `depo`.`cpu` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `brand` VARCHAR(50) NOT NULL,
  `clock_speed` INT NOT NULL, 
  `socket_type` VARCHAR(50) NOT NULL,
  `generation` VARCHAR(50) NOT NULL,
  `series` VARCHAR(50) NOT NULL,
  `core_count` INT NOT NULL, 
  `model` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),  
  UNIQUE INDEX `model_UNIQUE` (`model` ASC)
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
