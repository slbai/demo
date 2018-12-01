package hello.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import user.domain.User;
import user.service.UserService;

import java.util.Collection;

/**
 * Create by Walter on 2018/11/29
 */
@RestController
public class UserServiceProviderRestApiController {


    @Autowired
    UserService userService;


    @PostMapping("/user/save")
    public User saveUser(@RequestBody User user){
        if (userService.save(user)){
            return user;
        } else {
            return null;
        }
    }

    @GetMapping("/user/list")
    public Collection<User> list(){
        return userService.findAll();
    }
}
