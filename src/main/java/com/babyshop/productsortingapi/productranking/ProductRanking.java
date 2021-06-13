package com.babyshop.productsortingapi.productranking;

import com.babyshop.productsortingapi.products.Product;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "product_ranking_per_users")
public class ProductRanking {
    @Id
    private Integer id;
    private LocalDate created_at;
    private LocalDate updated_at;
    private LocalDate deleted_at;
    private Integer product_id;
    private Integer user_id;
    private Integer ranking;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Product product;

    public ProductRanking() {
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductRanking{" +
                "id=" + id +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", deleted_at=" + deleted_at +
                ", product_id=" + product_id +
                ", user_id=" + user_id +
                ", ranking=" + ranking +
                ", product=" + product.toString() +
                '}';
    }
}

