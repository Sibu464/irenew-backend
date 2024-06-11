package com.teama.irenew.models;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface AddressDAO extends ListCrudRepository<Address,Integer> {
   List<Address> findByUser_Id(Integer id);
}
