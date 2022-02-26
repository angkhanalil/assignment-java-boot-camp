package com.example.shoppingapi.CustomerOrder;

import com.example.shoppingapi.Shipping.CustomerAddressItemRepository;
import com.example.shoppingapi.model.CustomerAddressItem;
import com.example.shoppingapi.model.CustomerOrder;
import com.example.shoppingapi.model.CustomerOrderItem;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CustomerOrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerOrderItemRepository customerOrderItemRepository;

    @Autowired
    private CustomerAddressItemRepository customerAddressItemRepository;

    public ResponseEntity<List<CustomerOrder>> findCustomerOrderbyUser(Integer userid) {
        List<CustomerOrder> customerOrder = orderRepository.findByUserid(userid);

        if (!customerOrder.isEmpty()) {
            for(CustomerOrder order:customerOrder){
                List<CustomerOrderItem> customerOrderItem = customerOrderItemRepository.findByOrderid(order.getOrderid());
                order.setOrderItem(customerOrderItem);
            }

            return new ResponseEntity<>(customerOrder, HttpStatus.OK);
        }
        throw  new CustomerOrderNotFoundException(userid.toString());
    }

    public ResponseEntity<CustomerOrder> findCustomerOrderbyOrderId(String orderid) {

        CustomerOrder customerOrder = orderRepository.findByOrderid(orderid);
        if (customerOrder != null) {
            List<CustomerOrderItem> customerOrderItem = customerOrderItemRepository.findByOrderid(customerOrder.getOrderid());
            customerOrder.setOrderItem(customerOrderItem);
            return new ResponseEntity<>(customerOrder, HttpStatus.OK);
        }
        throw  new CustomerOrderNotFoundException(orderid);
    }

    //confirm order
    @Transactional
    public String confirmOrder(@NotNull RequestCustomerOrder requestCustomerOrder) {

        // ********** Address *****************
        CustomerAddressItem customerAddressItem = new CustomerAddressItem();
        customerAddressItem.setCustomerid(requestCustomerOrder.getUserid());
        customerAddressItem.setEmail(requestCustomerOrder.getShippingaddress().getEmail());
        customerAddressItem.setTelephone(requestCustomerOrder.getShippingaddress().getTelephone());
        customerAddressItem.setProvince(requestCustomerOrder.getShippingaddress().getProvince());
        customerAddressItem.setAddess(requestCustomerOrder.getShippingaddress().getAddess());
        customerAddressItem.setPostcode(requestCustomerOrder.getShippingaddress().getPostcode());
        customerAddressItem.setCity(requestCustomerOrder.getShippingaddress().getCity());
        customerAddressItem.setFullname(requestCustomerOrder.getShippingaddress().getFullname());
        // CustomerAddressItem addresshipping = customerAddressItemRepository.save(customerAddressItem);

        // ********** customerOrder *****************
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setUserid(requestCustomerOrder.getUserid());
        customerOrder.setNetam(requestCustomerOrder.getNetam());
        customerOrder.setOrderdate(new Date());
        customerOrder.setPaymenttype(requestCustomerOrder.getPaymenttype());
        customerOrder.setPaymentdate(requestCustomerOrder.getPaymentdate());
        customerOrder.setOrderid("ABC"); //generate order id
        customerOrder.setShippingaddress(customerAddressItem);
//        customerOrder.setShippingaddress(requestCustomerOrder.getShippingaddress());

        customerOrder.setOrderstatus("confirm");
        orderRepository.save(customerOrder);
        // ********** customerOrder *****************
        RequestCustomerOrderItem requestCustomerOrderItem = new RequestCustomerOrderItem();
        List<RequestCustomerOrderItem> requestCustomerOrderItemList = new ArrayList<>();
        for (RequestCustomerOrderItem item : requestCustomerOrder.getRequestCustomerOrderItemList()) {
            CustomerOrderItem customerOrderItem = new CustomerOrderItem();
            customerOrderItem.setProductid(item.getProductid());
            customerOrderItem.setQty(item.getQty());
            customerOrderItem.setPrice(item.getPrice());
            customerOrderItem.setOrderid("ABC");
            customerOrderItemRepository.save(customerOrderItem);

        }


        return "Success";
    }

}
