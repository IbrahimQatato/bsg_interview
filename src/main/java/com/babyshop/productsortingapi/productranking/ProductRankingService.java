package com.babyshop.productsortingapi.productranking;

import com.babyshop.productsortingapi.users.User;
import com.babyshop.productsortingapi.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductRankingService {
    private final ProductRankingRepository productRankingRepository;
    private final UserRepository userRepository;

    @Autowired
    public ProductRankingService(ProductRankingRepository productRankingRepository, UserRepository userRepository) {
        this.productRankingRepository = productRankingRepository;
        this.userRepository = userRepository;
    }

    public List<ProductRanking> getRankings() { return productRankingRepository.findAll();};

    public List<ProductRanking> getProductRankingsForUser(Integer userId){
        Optional<User> user = userRepository.findUserById(userId);
        if(!user.isPresent()){
            throw new IllegalStateException();
        }
        return productRankingRepository.findRankedProductsForUser(userId);
    }
}
