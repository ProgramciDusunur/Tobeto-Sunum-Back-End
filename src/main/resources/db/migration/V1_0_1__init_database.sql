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


CREATE TABLE IF NOT EXISTS `depo`.`shelf` (
  `id` INT AUTO_INCREMENT,
  `occupied_quantity` INT NOT NULL,
  `stock_id` INT,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `depo`.`stock` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(40) NOT NULL,
  `quantity` INT NOT NULL,
  `type_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `depo`.`stock_alert` (
    id INT NOT NULL AUTO_INCREMENT,    
    stock_id INT NOT NULL,
    alert_quantity INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT idstock_alert_UNIQUE UNIQUE (id),
    CONSTRAINT stock_id_UNIQUE UNIQUE (stock_id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `depo`.`employee` (
  `id` BINARY(16) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC)
) ENGINE = InnoDB;