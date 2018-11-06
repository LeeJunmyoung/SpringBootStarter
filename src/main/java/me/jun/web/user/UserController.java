
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
             return "hello";
    }

    @PostMapping("/users/create")
    public User create(@RequestBody User user){
        return user;
    }

}

