package com.cybersoft.osahaneat.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name = "username")
    private  String username;
    @Column(name = "password")

    private String password;
    @Column(name = "fullname")

    private String fullname;


    @Column(name = "create_date")

    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles roles;

   @OneToMany(mappedBy = "users")
    private Set<RatingFood> listRatingFood;



    @OneToMany(mappedBy = "users")
    private Set<RatingRestaurant> listRatingRestaurant;


    @OneToMany(mappedBy = "users")
    private Set<Orders> listOders;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public Set<RatingFood> getListRatingFood() {
        return listRatingFood;
    }

    public void setListRatingFood(Set<RatingFood> listRatingFood) {
        this.listRatingFood = listRatingFood;
    }

    public Set<RatingRestaurant> getListRatingRestaurant() {
        return listRatingRestaurant;
    }

    public void setListRatingRestaurant(Set<RatingRestaurant> listRatingRestaurant) {
        this.listRatingRestaurant = listRatingRestaurant;
    }

    public Set<Orders> getListOders() {
        return listOders;
    }

    public void setListOders(Set<Orders> listOders) {
        this.listOders = listOders;
    }
}
