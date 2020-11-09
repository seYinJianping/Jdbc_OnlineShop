package com.yjp.transaction;

public interface ITransaction {
    public void begin();
    public void commit();
    public void rollback();
}
