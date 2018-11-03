package me.jun.web.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import java.sql.SQLException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void di() throws SQLException {
        System.out.println(dataSource.getConnection().getMetaData().getURL());
        System.out.println(dataSource.getConnection().getMetaData().getDriverName());

        Account account = new Account();
        account.setUsername("jun");
        account.setPassword("12343");

        Account newAccount = accountRepository.save(account);

        System.out.println(newAccount.toString());


        System.out.println(accountRepository.findByUsername(newAccount.getUsername()).getId());
        System.out.println(accountRepository.findByUsername(newAccount.getUsername()).getUsername());
    }

}