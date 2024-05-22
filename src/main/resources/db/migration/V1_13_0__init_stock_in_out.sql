CREATE TABLE IF NOT EXISTS depo.stock_log (
  id INT NOT NULL AUTO_INCREMENT,
  transaction_code BINARY(16) NOT NULL,
  transaction_date DATETIME NOT NULL,
  user VARCHAR(20) NOT NULL,
  user_id BINARY(16) NOT NULL,
  product_type VARCHAR(45) NOT NULL,
  product_id INT NOT NULL,
  quantity INT NOT NULL,
  transaction_type VARCHAR(45) NOT NULL,
  transaction_detail VARCHAR(100) NULL DEFAULT NULL,
  transaction_status VARCHAR(45) NOT NULL,
  error_message VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX transaction_code_UNIQUE (transaction_code)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;