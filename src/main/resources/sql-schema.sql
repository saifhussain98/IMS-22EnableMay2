drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE IF NOT EXISTS `ims`.`items` (
    `itemsId` INT(11) NOT NULL AUTO_INCREMENT,
    `itemsname` VARCHAR(40) DEFAULT NULL,
    `value` INT(40) NOT NULL,
    PRIMARY KEY (`itemsId`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
    fk_id INT NOT NULL,
    `orderId` INT NOT NULL,
    PRIMARY KEY (orderId, fk_id),
    FOREIGN KEY (fk_id) REFERENCES customers(id)
);

CREATE TABLE IF NOT EXISTS `ims`. `order_items` (
fk_orderId INT NOT NULL,
fk_itemsId INT NOT NULL,
`order_items_id` INT UNIQUE NOT NULL,
`quantity` INT DEFAULT 1,
`total_cost` DECIMAL(12,2),

PRIMARY KEY (order_items_Id),
FOREIGN KEY (fk_orderId) REFERENCES orders(orderId),
FOREIGN KEY (fk_itemsId) REFERENCES items(itemsId)
);