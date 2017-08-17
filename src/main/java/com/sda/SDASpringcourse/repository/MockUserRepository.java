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

    //tak oadnotowana metoda zostanie uruchomiona tuz po utworzeniu obiektu tej klasy
    //zapełni ona liste userow mockowymi danymi
    @PostConstruct
    public void init() {
        User user = new User(1, "Bartek", "Mytko", "123456789");
        User user2 = new User(2, "Maria", "Mytko", "987654321");
        User user3 = new User(3, "Ewa", "Mytko", "147258369");
        User user4 = new User(4, "Mieczysław", "Mytko", "741852963");

        users.add(user);
        users.add(user2);
        users.add(user3);
        users.add(user4);
    }
}
