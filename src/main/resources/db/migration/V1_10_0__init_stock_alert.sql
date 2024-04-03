CREATE TABLE IF NOT EXISTS `depo`.`stock_alert` (
    id INT NOT NULL AUTO_INCREMENT,    
    stock_id INT NOT NULL,
    alert_quantity INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT idstock_alert_UNIQUE UNIQUE (id),
    CONSTRAINT stock_id_UNIQUE UNIQUE (stock_id)
) ENGINE=InnoDB;