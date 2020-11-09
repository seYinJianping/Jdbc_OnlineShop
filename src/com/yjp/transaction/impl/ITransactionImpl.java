package com.yjp.transaction.impl;

import com.yjp.transaction.ITransaction;
import com.yjp.util.DbUtil;

import java.sql.SQLException;

public class ITransactionImpl implements ITransaction {
    @Override
    public void begin() {
        try {
            DbUtil.getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void commit() {
        try {
            DbUtil.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void rollback() {
        try {
            DbUtil.getConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
