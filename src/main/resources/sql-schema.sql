DROP SCHEMA IF EXISTS ims;

CREATE SCHEMA IF NOT EXISTS ims;

USE ims ;

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
    `fkId` INT(11) NOT NULL,
    `orderId` INT(11) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (orderId, fkId),
    FOREIGN KEY (fkId) REFERENCES customers(id)
);

CREATE TABLE IF NOT EXISTS `ims`. `order_items` (
`order_items_id` INT(11) NOT NULL AUTO_INCREMENT,
`fkId` INT(11) NOT NULL,
`fk_orderId` INT NOT NULL,
`fk_itemsId` INT NOT NULL,
`item_quantity` INT(40) NOT NULL,
-- `total_cost_of_order` DEC(10, 2) NOT NULL,

PRIMARY KEY (order_items_id),
FOREIGN KEY (fkId) REFERENCES customers(id),
FOREIGN KEY (fk_orderId) REFERENCES orders(orderId),
FOREIGN KEY (fk_itemsId) REFERENCES items(itemsId)
);