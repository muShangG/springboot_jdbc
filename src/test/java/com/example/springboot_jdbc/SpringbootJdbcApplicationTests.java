package com.example.springboot_jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class SpringbootJdbcApplicationTests {
    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        System.out.println("输出"+dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println("输出"+connection);
        System.out.println("输出"+connection.getMetaData().getURL());
        connection.close();

    }

}
