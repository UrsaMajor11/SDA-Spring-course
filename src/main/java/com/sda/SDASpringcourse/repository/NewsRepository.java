package com.sda.SDASpringcourse.repository;

import com.sda.SDASpringcourse.model.News;

import java.util.List;

/**
 * Created by RENT on 2017-08-17.
 */
public interface NewsRepository {

    List<News> getAll();

    News getById(Integer id);

}
