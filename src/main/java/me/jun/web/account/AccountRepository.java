package me.jun.web.account;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface AccountRepository extends JpaRepository<Account,Long> {


    ArrayList<Account> findByUsername(String username);
}

