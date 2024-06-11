//package com.teama.irenew.services;
//
//import com.teama.irenew.customer.User;
//import com.teama.irenew.models.Address;
//import com.teama.irenew.repository.AddressRepository;
//import com.teama.irenew.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//
//public class AddressService {
//
//    UserRepository userRepository;
//    @Autowired
//    private AddressRepository addressRepository;
//
//    public List<Address> getUserAddresses(Integer userId) {
//       // User user = UserRepository.findById(userId).orElse(null);
//        User user = userRepository.findById(userId).orElse(null);
//        if (user != null) {
//            return addressRepository.findByUser(user);
//        }
//        return Collections.emptyList();
//    }
//
//
//    public Address editAddress(Integer addressId, Address updatedAddress) {
//        Address address = (Address) addressRepository.findById(addressId).orElse(null);
//       // Optional<Address> optionalAddress = addressRepository.findById(addressId).orElse(null);
//        if (address != null) {
//           // Address address = optionalAddress.get();
//            // Update address details
//            address.setStreet(updatedAddress.getStreet());
//            address.setStreetName(updatedAddress.getStreetName());
//            address.setSuburb(updatedAddress.getSuburb());
//            address.setCityProvince(updatedAddress.getCityProvince());
//            address.setPostalCode(updatedAddress.getPostalCode());
//            // Save the updated address
//            return addressRepository.save(address);
//        }
//        // Handle the case where the address with the given ID doesn't exist
//        throw new RuntimeException("Address not found with ID: " + addressId);
//    }
//    public Address setUserAddress(Integer userId, Address updatedAddress) {
//        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
//        Address address = user.getAddress(); // Assuming a user has only one address
//
//        if (address == null) {
//            address = new Address();
//            address.setUser(user);
//        }
//        address.setStreet(updatedAddress.getStreet());
//        address.setStreetName(updatedAddress.getStreetName());
//        address.setSuburb(updatedAddress.getSuburb());
//        address.setCityProvince(updatedAddress.getCityProvince());
//        address.setPostalCode(updatedAddress.getPostalCode());
//
//
//        return addressRepository.save(address);
//    }
//
//}
