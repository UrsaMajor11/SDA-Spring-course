package com.sda.SDASpringcourse.repository;

import com.sda.SDASpringcourse.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-08-16.
 */

@Component
public class MockUserRepository implements UserRepository {

    private List<User> users;

    public MockUserRepository() {
        this.users = new ArrayList<>();
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User getById(Integer id) {
        return users.get(id);
    }

    @PostConstruct
    public void init() {
        User user = new User(1, "Bartek", "Mytko", "123456789");

        users.add(user);
    }
}
