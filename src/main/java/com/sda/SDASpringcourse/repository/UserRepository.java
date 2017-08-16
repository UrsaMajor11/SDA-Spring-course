package com.sda.SDASpringcourse.repository;

import com.sda.SDASpringcourse.model.User;

import java.util.List;

/**
 * Created by RENT on 2017-08-16.
 */
public interface UserRepository {

    List<User> getAll();

    User getById(Integer id);

}
