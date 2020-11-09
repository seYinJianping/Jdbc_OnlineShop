package com.yjp.service;

import com.yjp.entity.*;

import java.util.List;

public interface IObjectService {
    //验证登陆
    public List<User> loginCheck(String username, String password);
    //获取所有品牌
    public List<Brand> listAllBrand();
    //获取所有商品的数量
    public List<Item> listAllItem();
    //创建订单
    public int createNewOrder(Order order);
    //更新库存
    public int updateItemStock(Order order);
    //品牌筛选商品
    public List<Item> getItemByBrand(String brandName);
    //注册判断
    public List registerCheck();
    //注册
    public int register(User user);
    //平台管理员登陆验证
    public List<Staff> adminLoginCheck(String username,String password);
}
