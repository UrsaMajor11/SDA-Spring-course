package com.sda.SDASpringcourse.repository;

import com.sda.SDASpringcourse.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by RENT on 2017-08-22.
 */
public interface JpaUserRepository extends CrudRepository<User, Integer> {

    //CrudRepository<User, Integer> -> to interfejs, ktory podaje zbior metod zwiazanych z create, read, update, delete

    //NIE BEDZIEMY TOWRZYC IMPKLEMENTACJI TEGO INTERFEJSU - SPRING SAM GO DOSTARCZY


    List<User> findByLastName(String lastName); //te metode tez dostarczy spring
    //potrzebujemy jej w ktoryms endpoincie w userController
    //nazwa metody jest znaczaca - mowi ona springowi co i po jakim polu ma szukac!!!
    //sygnatura tej metody mówi: napisz metode zwracajaca liste Userow wyszukujac ich po kolumnie lastName
    //lista wyrazen, z ktorych mozna sklejac nazwy metod:
    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation

}
