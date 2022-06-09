INSERT INTO `customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');
INSERT INTO `items` (`itemsname`, `value`) VALUES ('football', '10.99');
INSERT INTO `orders` (`fkId`) VALUES ('1');
INSERT INTO `order_items` (`fkId`, `fk_orderId`, `fk_itemsId`, `item_quantity`) VALUES ('1', '1', '1', '3');
