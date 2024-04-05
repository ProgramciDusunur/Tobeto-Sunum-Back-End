CREATE TABLE IF NOT EXISTS `depo`.`cpu_cooler` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(50) NOT NULL,
  `fan_length` VARCHAR(50) NOT NULL,
  `rpm` INT NOT NULL,
  `material` VARCHAR(50) NOT NULL,
  `led` VARCHAR(50) NOT NULL,
  `brand` VARCHAR(50) NOT NULL,
  `model` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),  
  UNIQUE INDEX `model_UNIQUE` (`model` ASC)
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;