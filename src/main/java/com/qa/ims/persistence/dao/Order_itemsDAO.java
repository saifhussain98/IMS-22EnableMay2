package com.qa.ims.persistence.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.ArrayList;

import java.util.List;



import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;



import com.qa.ims.persistence.domain.Order_items;

import com.qa.ims.utils.DBUtils;

public class Order_itemsDAO implements Dao<Order_items> {

    

    public static final Logger LOGGER = LogManager.getLogger();



    @Override

    public Order_items modelFromResultSet(ResultSet resultSet) throws SQLException {

    Long order_items_id = resultSet.getLong("order_items_id");

    Long fkId = resultSet.getLong("fkId");

    Long fk_orderId = resultSet.getLong("fk_orderId");

    Long fk_itemsId = resultSet.getLong("fk_itemsId");
    
    Long item_quantity = resultSet.getLong("item_quantity");
    
//    double total_cost_of_order = resultSet.getDouble("total_cost_of_order");

    return new Order_items(order_items_id, fkId, fk_orderId, fk_itemsId, item_quantity);

    }



    /**

    * Reads all order items from the database

    */

    @Override

    public List<Order_items> readAll() {

    try (Connection connection = DBUtils.getInstance().getConnection();

    Statement statement = connection.createStatement();

    ResultSet resultSet = statement.executeQuery("SELECT * FROM order_items");) {

    List<Order_items> order_items = new ArrayList<>();

    while (resultSet.next()) {

    order_items.add(modelFromResultSet(resultSet));

    }

    return order_items;

    } catch (SQLException e) {

    LOGGER.debug(e);

    LOGGER.error(e.getMessage());

    }

    return new ArrayList<>();

    }



    public Order_items readLatest() {

    try (Connection connection = DBUtils.getInstance().getConnection();

    Statement statement = connection.createStatement();

    ResultSet resultSet = statement.executeQuery("SELECT * FROM order_items ORDER BY order_items_id DESC LIMIT 1");) {

    resultSet.next();

    return modelFromResultSet(resultSet);

    } catch (Exception e) {

    LOGGER.debug(e);

    LOGGER.error(e.getMessage());

    }

    return null;

    }



    /**

    * Creates an order items in the database

    */

    @Override

    public Order_items create(Order_items order_items) {

    try (Connection connection = DBUtils.getInstance().getConnection();

    PreparedStatement statement = connection.prepareStatement("INSERT INTO order_items(fkId, fk_orderId, fk_itemsId, item_quantity) VALUE (?, ?, ?, ?)");) {

    statement.setLong(1, order_items.getFkId());

    statement.setLong(2, order_items.getFk_orderId());

    statement.setLong(3, order_items.getFk_itemsId());
    
    statement.setLong(4, order_items.getItem_quantity());

//    statement.setDouble(3, order_items.getTotal_cost_of_order());

    statement.executeUpdate();

    return readLatest();

    } catch (Exception e) {

    LOGGER.debug(e);

    LOGGER.error(e.getMessage());

    }

    return null;

    }

     @Override

    public Order_items read(Long order_items_id) {

    try (Connection connection = DBUtils.getInstance().getConnection();

    PreparedStatement statement = connection.prepareStatement("SELECT * FROM order_items WHERE order_items_id = ?");) {

    statement.setLong(1, order_items_id);

    try (ResultSet resultSet = statement.executeQuery();) {

    resultSet.next();

    return modelFromResultSet(resultSet);

    }

    } catch (Exception e) {

    LOGGER.debug(e);

    LOGGER.error(e.getMessage());

    }

    return null;

    }



    /**

    * Updates an order items in the database

    */

    @Override

    public Order_items update(Order_items order_items) {

    try (Connection connection = DBUtils.getInstance().getConnection();

    PreparedStatement statement = connection

    .prepareStatement("UPDATE order_items SET fkId = ?, fk_orderId = ?, fk_itemsId = ?, item_quantity = ?= ? WHERE order_items_id = ?");) {

    	statement.setLong(1, order_items.getFkId());

        statement.setLong(2, order_items.getFk_orderId());

        statement.setLong(3, order_items.getFk_itemsId());
        
        statement.setLong(2, order_items.getItem_quantity());

//        statement.setDouble(3, order_items.getTotal_cost_of_order());

    statement.executeUpdate();

    return read(order_items.getOrder_items_id());

    } catch (Exception e) {

    LOGGER.debug(e);

    LOGGER.error(e.getMessage());

    }

    return null;

    }



    /**

    * Deletes an order items in the database

    */

    @Override

    public int delete(long order_items_id) {

    try (Connection connection = DBUtils.getInstance().getConnection();

    PreparedStatement statement = connection.prepareStatement("DELETE FROM order_items WHERE order_item_id = ?");) {

    statement.setLong(1, order_items_id);

    int ret = statement.executeUpdate();

    LOGGER.debug("Successfully Deleted");

    return ret;

    } catch (Exception e) {

    LOGGER.debug(e);

    LOGGER.error(e.getMessage());

    }

    return 0;

    }

    }