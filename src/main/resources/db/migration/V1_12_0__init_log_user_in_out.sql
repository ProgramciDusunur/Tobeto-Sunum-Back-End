CREATE TABLE IF NOT EXISTS depo.user_log (
  id INT NOT NULL AUTO_INCREMENT,
  transaction_code BINARY(16) NOT NULL,
  user VARCHAR(45) NOT NULL,
  user_id BINARY(16) NOT NULL,
  transaction_date DATETIME NOT NULL,
  transaction_type VARCHAR(45) NOT NULL,
  transaction_detail VARCHAR(45) NOT NULL,
  error_message VARCHAR(45) DEFAULT NULL,
  PRIMARY KEY (transaction_code),
  INDEX (id)
) 
ENGINE = InnoDB 
DEFAULT CHARSET = utf8mb4 
COLLATE = utf8mb4_0900_ai_ci;
