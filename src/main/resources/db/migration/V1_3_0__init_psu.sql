CREATE TABLE IF NOT EXISTS `depo`.`psu` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `watt` INT NOT NULL,
  `efficiency` VARCHAR(50) NOT NULL,
  `modular` BOOLEAN NOT NULL,
  `type` VARCHAR(50) NOT NULL,
  `pcie_gen_5_support` BOOLEAN NOT NULL,
  `brand` VARCHAR(45) NOT NULL,
  `model` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),  
  UNIQUE INDEX `model_UNIQUE` (`model` ASC)
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;