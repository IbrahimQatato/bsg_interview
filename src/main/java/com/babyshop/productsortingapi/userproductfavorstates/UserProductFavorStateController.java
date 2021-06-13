package com.babyshop.productsortingapi.userproductfavorstates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/favorstatus")
public class UserProductFavorStateController {
    private final UserProductFavorStateService userProductFavorStateService;

    @Autowired
    public UserProductFavorStateController(UserProductFavorStateService userProductFavorStateService) {
        this.userProductFavorStateService = userProductFavorStateService;
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    void newFavorState(@RequestBody UserProductFavorState newFavorState) {
            userProductFavorStateService.addNewFavorState(newFavorState);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "invalid user, product, or favor_status")
    @ExceptionHandler(IllegalStateException.class)
    public void handleException(IllegalStateException ex){  }

}
