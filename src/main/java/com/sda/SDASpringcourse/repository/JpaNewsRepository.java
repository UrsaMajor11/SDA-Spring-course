package com.sda.SDASpringcourse.repository;

import com.sda.SDASpringcourse.model.News;
import com.sda.SDASpringcourse.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by RENT on 2017-08-22.
 */
public interface JpaNewsRepository extends CrudRepository<News, Integer> {

    //CrudRepository<User, Integer> -> to interfejs, ktory podaje zbior metod zwiazanych z create, read, update, delete

    //NIE BEDZIEMY TOWRZYC IMPKLEMENTACJI TEGO INTERFEJSU - SPRING SAM GO DOSTARCZY !!!

    //dodajemy sygnature metody pobierajacej newsy po zadanym userze
    //nie bedziemy dostarczac jej implementacji - spring sam ja dostaarczy !!!
    List<News> findByUser(User user);
}
