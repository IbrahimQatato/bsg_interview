package com.babyshop.productsortingapi.productranking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRankingRepository extends JpaRepository<ProductRanking, Integer> {
    @Query(
            value = "SELECT * " +
                    "FROM (SELECT * FROM product_ranking_per_users, products " +
                    "WHERE products.id = product_id) AS ranked_products " +
                    "WHERE  user_id = ?1 " +
                    "ORDER BY ranking",
            nativeQuery = true)
    List<ProductRanking> findRankedProductsForUser(Integer userId);
}
