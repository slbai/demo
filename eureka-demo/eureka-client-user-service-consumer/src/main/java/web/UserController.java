package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import user.service.UserService;


/**
 * Create by Walter on 2018/11/21
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;
}
