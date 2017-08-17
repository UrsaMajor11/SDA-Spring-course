package com.sda.SDASpringcourse.model;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by RENT on 2017-08-17.
 */
public class News {

    private Integer id;

    private String title;

    private String description;

    private String smallImgLink;

    private String bigImgLink;

    private Integer userId;

    public News() {
    }

    public News(Integer id, String title, String description, String smallImgLink, String bigImgLink, Integer userId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.smallImgLink = smallImgLink;
        this.bigImgLink = bigImgLink;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSmallImgLink() {
        return smallImgLink;
    }

    public void setSmallImgLink(String smallImgLink) {
        this.smallImgLink = smallImgLink;
    }

    public String getBigImgLink() {
        return bigImgLink;
    }

    public void setBigImgLink(String bigImgLink) {
        this.bigImgLink = bigImgLink;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    //moj dodatkowy setter - zwraca skrocony opis
    public String getAbbreviateDescription() {
        return StringUtils.abbreviate(this.description, 50);
    }
}
