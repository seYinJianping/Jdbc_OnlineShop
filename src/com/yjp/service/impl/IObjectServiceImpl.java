package com.yjp.service.impl;


import com.yjp.dao.IObjectDao;
import com.yjp.entity.*;
import com.yjp.service.IObjectService;
import com.yjp.transaction.ITransaction;
import com.yjp.util.DbUtil;
import factory.ObjectFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IObjectServiceImpl implements IObjectService {
    private IObjectDao dao = (IObjectDao) ObjectFactory.getObject("IObjectDao");
    private ITransaction ts = (ITransaction) ObjectFactory.getObject("ITransaction");


    @Override
    public List<User> loginCheck(String username, String password) {
        List<User> list = null;
        try {
            list = dao.loginCheck(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtil.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public List registerCheck() {
        List list = null;
        try {
            list = dao.registerCheck();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtil.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public int register(User user) {
        int result = -1;
        try {
            ts.begin();
            result = dao.register(user);
            ts.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            ts.rollback();
        } finally {
            try {
                DbUtil.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public List<Staff> adminLoginCheck(String username, String password) {
        List<Staff> list = new ArrayList<Staff>();
        try {
            list = dao.adminLoginCheck(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeConnection();
        }
        return list;
    }

    @Override
    public List<Brand> listAllBrand() {
        List<Brand> list = null;
        try {
            list = dao.listAllBrand();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtil.closeConnection();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public List<Item> listAllItem() {
        List<Item> list = null;
        try {
            list = dao.listAllItem();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeConnection();
        }
        return list;
    }

    @Override
    public int createNewOrder(Order order) {
        int result = -1;
        try {
            ts.begin();
            result = dao.createNewOrder(order);
            ts.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            ts.rollback();
        } finally {
            try {
                DbUtil.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public int updateItemStock(Order order) {
        int result = -1;
        try {
            ts.begin();
            dao.updateItemStock(order);
            ts.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            ts.rollback();
        } finally {
            try {
                DbUtil.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public List<Item> getItemByBrand(String brandName) {
        List<Item> list = null;
        try {
            list = dao.getItemByBrand(brandName);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtil.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }



}
