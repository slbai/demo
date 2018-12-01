package hello.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import user.domain.User;
import user.service.UserService;

import java.util.Collection;


/**
 * Create by Walter on 2018/11/21
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user/save")
    public User saveUser(@RequestParam String name){
        User user = new User();
        user.setName(name);
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
