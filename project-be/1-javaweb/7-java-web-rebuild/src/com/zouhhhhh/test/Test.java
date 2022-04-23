package com.zouhhhhh.test;

import com.zouhhhhh.utils.JdbcTool;

import java.sql.Connection;

/**
 * @author zouhao
 * @date 2022/4/17
 */
public class Test {

    public static void main(String[] args) {
        Connection connection = JdbcTool.getConnection();
        System.out.println(connection);
        JdbcTool.release(connection, null, null);
    }

}
