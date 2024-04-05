CREATE TABLE IF NOT EXISTS `depo`.`motherboard` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cpu_socket_type` VARCHAR(50) NOT NULL,
  `cpu_compatibility` BOOLEAN NOT NULL, 
  `ram_type` VARCHAR(50) NOT NULL,
  `size` VARCHAR(50) NOT NULL,
  `ram_slots` INT NOT NULL, 
  `brand` VARCHAR(45) NOT NULL,
  `model` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),  
  UNIQUE INDEX `model_UNIQUE` (`model` ASC)
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;