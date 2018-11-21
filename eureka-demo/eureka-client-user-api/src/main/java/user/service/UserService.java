package user.service;

import user.domain.User;

import java.util.Collection;

/**
 * Create by Walter on 2018/11/21
 */
public interface UserService {

    boolean save(User user);

    Collection<User> findAll();
}
