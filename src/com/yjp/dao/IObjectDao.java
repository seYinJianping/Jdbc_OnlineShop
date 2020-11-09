package com.yjp.dao;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.yjp.entity.*;

import java.sql.SQLException;
import java.util.List;

public interface IObjectDao {

    public List<User> loginCheck(String username, String password) throws SQLException;
    public List<Brand> listAllBrand() throws SQLException;
    public List<Item> listAllItem() throws SQLException;
    public int createNewOrder(Order order) throws SQLException;
    public int updateItemStock(Order order) throws SQLException;
    public List<Item> getItemByBrand(String brandName) throws SQLException;
    public List registerCheck() throws SQLException;
    public int register(User user) throws SQLException;
    public List<Staff> adminLoginCheck(String username,String password) throws SQLException;
}
