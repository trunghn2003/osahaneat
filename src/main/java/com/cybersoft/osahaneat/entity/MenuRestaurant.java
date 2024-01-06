package com.cybersoft.osahaneat.entity;

import com.cybersoft.osahaneat.entity.key.KeyMenyRestaurant;
import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "MenuRestaurant")
public class MenuRestaurant {
    @EmbeddedId
    KeyMenyRestaurant keys;
    @ManyToOne
    @JoinColumn(name = "cate_id", insertable = false,updatable = false)
    private Category category;
    @ManyToOne
    @JoinColumn(name = "res_id", insertable = false,updatable = false)
    private Restaurant restaurant;

    @Column(name = "create_date")
    private Date createDate;

    public KeyMenyRestaurant getKeys() {
        return keys;
    }

    public void setKeys(KeyMenyRestaurant keys) {
        this.keys = keys;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
