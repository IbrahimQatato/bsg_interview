package com.babyshop.productsortingapi.userproductfavorstates;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_product_favor_states")
public class UserProductFavorState {
    @Id
    @GeneratedValue
    private Integer Id;
    private Integer user_id;
    private Integer product_id;
    private String favor_state;

    public UserProductFavorState(Integer user_id, Integer product_id, String favor_state) {
        this.user_id = user_id;
        this.product_id = product_id;
        this.favor_state = favor_state;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getFavor_state() {
        return favor_state;
    }

    public void setFavor_state(String favor_state) {
        this.favor_state = favor_state;
    }

    @Override
    public String toString() {
        return "userProductFavorState{" +
                "Id=" + Id +
                ", user_id=" + user_id +
                ", product_id=" + product_id +
                ", favor_state='" + favor_state + '\'' +
                '}';
    }
}
