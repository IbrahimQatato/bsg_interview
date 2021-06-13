package com.babyshop.productsortingapi.userproductfavorstates;

import com.babyshop.productsortingapi.products.Product;
import com.babyshop.productsortingapi.products.ProductRepository;
import com.babyshop.productsortingapi.users.User;
import com.babyshop.productsortingapi.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProductFavorStateService {

    private final UserProductFavorStateRepository userProductFavorStateRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Autowired
    public UserProductFavorStateService(UserProductFavorStateRepository userProductFavorStateRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.userProductFavorStateRepository = userProductFavorStateRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }


    public UserProductFavorState save(UserProductFavorState newFavorState) {
        return userProductFavorStateRepository.save(newFavorState);
    }

    public void addNewFavorState(UserProductFavorState newFavorState) {
        String state = newFavorState.getFavor_state();
        Optional<User> user = userRepository.findUserById(newFavorState.getUser_id());
        Optional<Product> product = productRepository.findProductById(newFavorState.getProduct_id());
        if ((!state.equals("like") && !state.equals("impassive"))||!user.isPresent()||!product.isPresent()){
                throw new IllegalStateException();
        }
            userProductFavorStateRepository.save(newFavorState);
    }

}
