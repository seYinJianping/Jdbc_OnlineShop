package com.yjp.dao.impl;

import com.yjp.dao.IObjectDao;
import com.yjp.dao.IObjectMapper;
import com.yjp.entity.*;
import com.yjp.util.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class IObjectDaoImpl implements IObjectDao {


    //用户界面登陆检查
    @Override
    public List<User> loginCheck(String username, String userPassword) throws SQLException {
        class loginCheckObjectMapper implements IObjectMapper<User>{
        @Override
        public User getObjectFromResultSet(ResultSet rs) throws SQLException {
            User user = new User();
            user.setUserId(rs.getInt("UserId"));
            user.setUserName(rs.getString("UserName"));
            user.setUserPassword(rs.getString("UserPassword"));
            return user;
        }
    }
        return JdbcTemplate.executeQuery("select UserId,UserName,UserPassword from user where UserName =? and UserPassword = ?",new loginCheckObjectMapper(),username,userPassword);
    }

    @Override
    public List registerCheck() throws SQLException {
        class registerCheckMapper implements IObjectMapper{

            @Override
            public Object getObjectFromResultSet(ResultSet rs) throws SQLException {
                String uername = rs.getString("UserName");
                return uername;
            }
        }
        return JdbcTemplate.executeQuery("select UserName from user",new registerCheckMapper(),null);
    }

    //用户注册
    @Override
    public int register(User user) throws SQLException {
        return JdbcTemplate.executeUpdate("insert into user (UserName,UserPassword) values (?,?)",user.getUserName(),user.getUserPassword());
    }


    //平台管理员登录验证
    @Override
    public List<Staff> adminLoginCheck(String username, String password) throws SQLException {
        class adminLoginCheckMapper implements IObjectMapper{

            @Override
            public Object getObjectFromResultSet(ResultSet rs) throws SQLException {
                Staff staff = new Staff();
                staff.setStaffName(rs.getString("StaffName"));
                staff.setStaffPassword(rs.getString("StaffPwd"));
                return staff;
            }
        }
        return JdbcTemplate.executeQuery("select StaffName,StaffPwd from staff where StaffName=? and StaffPwd=?;",new adminLoginCheckMapper(),username,password);
    }


    //品牌JComboBox获取值
    @Override
    public List<Brand> listAllBrand() throws SQLException {
        class listAllBrandObjectMapper implements IObjectMapper{

            @Override
            public Object getObjectFromResultSet(ResultSet rs) throws SQLException {
                Brand brand = new Brand();
                brand.setBrandId(rs.getInt("BrandId"));
                brand.setBrandName(rs.getString("BrandName"));
                brand.setBrandSupplier(rs.getString("BrandSupplier"));
                brand.setBrandCharger(rs.getString("BrandCharger"));
                brand.setBrandAddress(rs.getString("BrandAddress"));
                return brand;
            }
        }

        return JdbcTemplate.executeQuery("select BrandId,BrandName,BrandSupplier,BrandCharger,BrandAddress from brand;",new listAllBrandObjectMapper(),null);
    }


    //获取所有的商品信息
    @Override
    public List<Item> listAllItem() throws SQLException {
        class listAllItemObjectMapper implements IObjectMapper{

            @Override
            public Object getObjectFromResultSet(ResultSet rs) throws SQLException {
                Item item = new Item();
                item.setItemId(rs.getInt("ItemId"));
                item.setItemName(rs.getString("ItemName"));
                item.setItemBrand(rs.getString("ItemBrand"));
                item.setItemPrice(rs.getInt("ItemPrice"));
                item.setItemSupplier(rs.getString("ItemSupplier"));
                item.setItemStock(rs.getInt("ItemStock"));
                item.setItemPic(rs.getString("ItemPic"));
                return item;
            }
        }
        return JdbcTemplate.executeQuery("select ItemId,ItemName,ItemBrand, ItemPrice, ItemSupplier, ItemStock,ItemPic from items;",new listAllItemObjectMapper(),null);
    }


    //用户创建新订单
    @Override
    public int createNewOrder(Order order) throws SQLException {
        return JdbcTemplate.executeUpdate("insert into orders (OrderAccount, OrderName, OrderTel, OrderAdd, OrderItemBrand, OrderItemName, OrderCount, OrderBill) values (?,?,?,?,?,?,?,?);",order.getOrderAccount(),order.getOrderName(),order.getOrderTel(),order.getOrderAdd(),order.getOrderItemBrand(),order.getOrderItemName(),order.getOrderCount(),order.getOrderBill());
    }

    //更新商品库存
    @Override
    public int updateItemStock(Order order) throws SQLException {
        return JdbcTemplate.executeUpdate("update items set ItemStock = ItemStock - ? where ItemName = ?;",order.getOrderCount(),order.getOrderItemName());
    }


    //通过品牌查找商品
    @Override
    public List<Item> getItemByBrand(String brandName) throws SQLException {
        class getItemByBrandMapper implements IObjectMapper{

            @Override
            public Object getObjectFromResultSet(ResultSet rs) throws SQLException {
                Item item = new Item();
                item.setItemId(rs.getInt("ItemId"));
                item.setItemName(rs.getString("ItemName"));
                item.setItemBrand(rs.getString("ItemBrand"));
                item.setItemPrice(rs.getInt("ItemPrice"));
                item.setItemSupplier(rs.getString("ItemSupplier"));
                item.setItemStock(rs.getInt("ItemStock"));
                item.setItemPic(rs.getString("ItemPic"));
                return item;
            }
        }
        return JdbcTemplate.executeQuery("select ItemId,ItemName,ItemBrand, ItemPrice, ItemSupplier, ItemStock,ItemPic from items where ItemBrand = ?;",new getItemByBrandMapper(),brandName);
    }


}
