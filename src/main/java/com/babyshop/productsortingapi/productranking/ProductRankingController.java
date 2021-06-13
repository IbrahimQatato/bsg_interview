package com.babyshop.productsortingapi.productranking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/rankings")
public class ProductRankingController {
    private final ProductRankingService productRankingService;

    @Autowired
    public ProductRankingController(ProductRankingService productRankingService) {
        this.productRankingService = productRankingService;
    }

    @GetMapping
    public List<ProductRanking> getRankings() {
        return productRankingService.getRankings();
    }

    @RequestMapping(path = "/{userId}", method = RequestMethod.GET)
    public List<ProductRanking> getProductRankingsForUser(@PathVariable(name = "userId") Integer userId){
        return productRankingService.getProductRankingsForUser(userId);
    }
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "user with this id doesn't exist")
    @ExceptionHandler(IllegalStateException.class)
    public void handleException(IllegalStateException ex){    }
}
