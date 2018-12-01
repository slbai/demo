package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import user.domain.User;
import user.service.UserService;

import java.util.Collection;

@Service
public class UserServiceProxy implements UserService {

    private final static String PROVIDER_URI = "http://user-service-provider";

    @Autowired
    RestTemplate restTemplate;

    @Override
    public boolean save(User user) {
        User object = restTemplate.postForObject(PROVIDER_URI + "/user/save",user,User.class);
        return object != null;
    }

    @Override
    public Collection<User> findAll() {
        return restTemplate.getForObject(PROVIDER_URI + "/user/list", Collection.class);
    }

}
