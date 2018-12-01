package hello.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import user.domain.User;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepository {

    private ConcurrentMap<Long,User> repository = new ConcurrentHashMap<>();

    private AtomicLong idGenerator = new AtomicLong();

    public boolean save(User user) {
        long id = idGenerator.addAndGet(1L);
        user.setId(id);
        return repository.putIfAbsent(id,user) == null;
    }

    public Collection<User> findAll() {
        return repository.values();
    }
}
