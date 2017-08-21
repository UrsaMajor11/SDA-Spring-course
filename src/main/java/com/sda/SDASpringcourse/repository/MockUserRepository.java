package com.sda.SDASpringcourse.repository;

import com.sda.SDASpringcourse.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<User> getAllByLastName(String lastName) {

        List<User> outputList = users.stream()
                .filter(e -> e.getLastName().startsWith(lastName))
                .collect(Collectors.toList());

        return outputList;
    }

    @Override
    public User getById(Integer id) {
        return users.get(id);
    }

    @Override
    public boolean add(User user) {
        //ustalam id dla nowego newsa, jako wielkosc listy (dodajemy na koncu listy)
        user.setId(users.size()); //błędogenne w przypadku usuwania jakis newsow (bo najpierw usuniemy, rozmiar sie zmniejszy i podstawimy nowy element w miejsce ostatniego, ktory w tymmomencie istnieje)

        users.add(user);

        return true; //za kazdym razem, celowo
    }

    //tak oadnotowana metoda zostanie uruchomiona tuz po utworzeniu obiektu tej klasy przez Springa
    //zapełni ona liste userow mockowymi danymi
    @PostConstruct
    public void init() {
        User user0 = new User(0, "Jan", "Kowalski", "123456789");
        User user1 = new User(1, "Bartek", "Mytko", "123456789");
        User user2 = new User(2, "Maria", "Mytko", "987654321");
        User user3 = new User(3, "Ewa", "Mytko", "147258369");
        User user4 = new User(4, "Mieczysław", "Mytko", "741852963");

        users.add(user0);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
    }
}
