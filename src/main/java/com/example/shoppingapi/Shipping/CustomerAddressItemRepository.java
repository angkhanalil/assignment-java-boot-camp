package com.example.shoppingapi.Shipping;

import com.example.shoppingapi.model.CustomerAddressItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerAddressItemRepository extends JpaRepository<CustomerAddressItem,Integer> {

    List<CustomerAddressItem>  findByCustomerid(Integer customerid);

}
