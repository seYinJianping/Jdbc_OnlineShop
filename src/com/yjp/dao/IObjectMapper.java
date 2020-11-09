package com.yjp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IObjectMapper<T> {
    public T getObjectFromResultSet(ResultSet rs) throws SQLException;
}
