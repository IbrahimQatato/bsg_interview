package com.babyshop.productsortingapi.products;

import com.babyshop.productsortingapi.images.Image;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

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
    @OneToMany(mappedBy = "product_id")
    private List<Image> images;
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

    public List<Image> getImages() {
        return images;
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
