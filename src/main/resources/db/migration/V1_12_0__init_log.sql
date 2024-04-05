CREATE TABLE IF NOT EXISTS depo.log (
  id INT NOT NULL,
  shelf_id INT NULL,
  stock_id INT NULL,
  quantity INT NOT NULL,
  date DATETIME NOT NULL,
  process_type VARCHAR(50) NOT NULL,
  employee_id BINARY(16) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC)
) ENGINE = InnoDB;
