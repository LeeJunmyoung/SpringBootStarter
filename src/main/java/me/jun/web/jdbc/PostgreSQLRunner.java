/*
package me.jun.web.jdbc;*//*

package me.jun.web.jdbc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component
public class PostgreSQLRunner implements ApplicationRunner {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try(Connection connection = dataSource.getConnection()) {

            String sql = "CREATE TABLE USER_DATATABLE(id INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (id))";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println(connection.getMetaData().getUserName());
            System.out.println( connection.getMetaData().getURL());
            jdbcTemplate.execute("INSERT INTO USER_DATATABLE VALUES (3, 'junmyoung')");



        }



    }
}


*/
