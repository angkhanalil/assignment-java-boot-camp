package com.example.shoppingapi.Shipping;

import com.example.shoppingapi.model.CustomerAddressItem;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CustomerAddressItemService {

    @Autowired
    private CustomerAddressItemRepository customerAddressItemRepository;

    public List<CustomerAddressItem> findCustomerAddress(Integer customerid) {
        CustomerAddressItem customerAddressItem = new CustomerAddressItem();
        List<CustomerAddressItem> result = customerAddressItemRepository.findByCustomerid(customerid);
        return result;
    }

    @Transactional
    public CustomerAddressItem addShipping(@NotNull RequestShipping requestShipping) {

        CustomerAddressItem addressItem = new CustomerAddressItem();

        addressItem.setAddess(requestShipping.getAddess());
        addressItem.setFullname(requestShipping.getFullname());
        addressItem.setCustomerid(requestShipping.getCustomerid());
        addressItem.setCity(requestShipping.getCity());
        addressItem.setPostcode(requestShipping.getPostcode());
        addressItem.setProvince(requestShipping.getProvince());
        addressItem.setTelephone(requestShipping.getTelephone());

        CustomerAddressItem result = customerAddressItemRepository.save(addressItem);
        return result;
    }

}
