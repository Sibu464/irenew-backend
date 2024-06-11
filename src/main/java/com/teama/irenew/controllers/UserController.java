package com.teama.irenew.controllers;

import com.teama.irenew.customer.User;
import com.teama.irenew.models.Address;
import com.teama.irenew.models.AddressDAO;
//import com.teama.irenew.services.AddressService;
import com.teama.irenew.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("irenew/users")
public class UserController {
    private final UserService userService;
   // private AddressService addressService;
   private AddressDAO addressDAO;

    @Autowired
    public UserController(UserService userService,AddressDAO addressDAO) {
        this.userService = userService;
        this.addressDAO=addressDAO;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        User user = userService.findUserById(id);
        return ResponseEntity.ok(user);
    }


//    @GetMapping("/{userId}/addresses")
//    public ResponseEntity<List<Address>> getUserAddresses(@PathVariable Integer userId) {
//        List<Address> addresses = addressService.getUserAddresses(userId);
//        return ResponseEntity.ok(addresses);
//    }
@GetMapping("/{userId}/address")
public ResponseEntity<List<Address>> getAddress(
        @AuthenticationPrincipal User user, @PathVariable Integer userId) {

    return ResponseEntity.ok(addressDAO.findByUser_Id(userId));
}
//Set address
    @PutMapping("/{userId}/address")
    public ResponseEntity<Address> putAddress(
            @AuthenticationPrincipal User user, @PathVariable Integer userId,
            @RequestBody Address address) {

        address.setId(null);
        User refUser = new User();

        refUser.setId
                (userId);
        address.setUser(refUser);
        Address savedAddress = addressDAO.save(address);

        return ResponseEntity.ok(savedAddress);
    }

    @PatchMapping("/{userId}/address/{addressId}")
    public ResponseEntity<Address> patchAddress(
            @AuthenticationPrincipal User user, @PathVariable Integer userId,
            @PathVariable Integer addressId, @RequestBody Address address) {

        if (address.getId() == addressId) {
            Optional<Address> opOriginalAddress = addressDAO.findById(addressId);
            if (opOriginalAddress.isPresent()) {
                User originalUser = opOriginalAddress.get().getUser();
                if (originalUser.getId() == userId) {
                    address.setUser(originalUser);
                    Address savedAddress = addressDAO.save(address);

                    return ResponseEntity.ok(savedAddress);
                }
            }
        }
        return ResponseEntity.badRequest().build();
    }


}
