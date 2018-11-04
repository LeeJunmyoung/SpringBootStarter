
package me.jun.web.user;

import me.jun.web.account.Account;
import me.jun.web.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/hello")
    public String hello() {
        Account account = new Account();
        account.setUsername("jun");
        account.setPassword("12343");

        Account newAccount = accountRepository.save(account);

        System.out.println(newAccount);



        accountRepository.findByUsername(newAccount.getUsername()).forEach(value ->{
            System.out.println(value.toString());
        });




        return "hello";
    }

    @PostMapping("/users/create")
    public User create(@RequestBody User user){
        return user;
    }

}

