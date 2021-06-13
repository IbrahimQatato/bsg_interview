package com.babyshop.productsortingapi.products;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "products")
public class Product {
    @Id
    private Integer id;
    private LocalDate created_at;
    private LocalDate updated_at;
    private LocalDate deleted_at;
    private String short_description;
    private String description;
    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", deleted_at=" + deleted_at +
                ", short_description='" + short_description + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
