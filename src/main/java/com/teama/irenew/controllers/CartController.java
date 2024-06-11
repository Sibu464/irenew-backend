package com.teama.irenew.controllers;

import com.teama.irenew.customer.User;
import com.teama.irenew.models.Cart;
import com.teama.irenew.models.CartDAO;
import com.teama.irenew.models.Product;
import com.teama.irenew.services.ProductService;
import com.teama.irenew.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("irenew/cart")
public class CartController {
    private final UserService userService;
    private ProductService productService;
    // private AddressService addressService;
    private CartDAO cartDAO;

    @Autowired
    public CartController(UserService userService,CartDAO cartDAO){
        this.userService = userService;
        this.cartDAO = cartDAO;
    }

    @GetMapping("/{userId}/items")
    public ResponseEntity<List<Cart>> getCartItems(
            @AuthenticationPrincipal User user, @PathVariable Integer userId) {

        return ResponseEntity.ok(cartDAO.findByUser_Id(userId));
    }

    //add cart Item
    @PutMapping("/{userId}/item")
    public ResponseEntity<Cart> putCart(
            @AuthenticationPrincipal User user, @PathVariable Integer userId,
            @RequestBody Cart cart) {

        cart.setId(null);
        User refUser = new User();

        refUser.setId
                (userId);
        cart.setUser(refUser);


        System.out.println("/////////////////////////////////////////////////");
        System.out.println(cart.getUser().getName());
        Cart savedCart = cartDAO.save(cart);

        return ResponseEntity.ok(savedCart);
    }
//edit cart
    @PatchMapping("/{userId}/cart/{cartId}")
    public ResponseEntity<Cart> patchCartItem(
            @AuthenticationPrincipal User user, @PathVariable Integer userId,
            @PathVariable Integer cartId, @RequestBody Cart cart) {

        if (cart.getId() == cartId) {
            Optional<Cart> opOriginalCart = cartDAO.findById(cartId);
            if (opOriginalCart.isPresent()) {
                User originalUser = opOriginalCart.get().getUser();
                if (originalUser.getId() == userId) {
                    cart.setUser(originalUser);
                    Cart savedCart = cartDAO.save(cart);

                    return ResponseEntity.ok(savedCart);
                }
            }
        }
        return ResponseEntity.badRequest().build();
    }






}
