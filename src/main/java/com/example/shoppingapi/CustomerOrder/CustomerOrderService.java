package com.example.shoppingapi.CustomerOrder;

import com.example.shoppingapi.model.CustomerOrder;
import com.example.shoppingapi.model.CustomerOrderItem;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
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

    public void findCustomerOrderbyUser(String userid) {

    }

    public void findCustomerOrderbyOrderId(String orderid) {

    }

    //confirm order
    @Transactional
    public String confirmOrder(@NotNull RequestCustomerOrder requestCustomerOrder) {

        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setUserid(requestCustomerOrder.getUserid());
        customerOrder.setNetam(requestCustomerOrder.getNetam());
        customerOrder.setOrderdate(new Date());
        customerOrder.setPaymenttype(requestCustomerOrder.getPaymenttype());
        customerOrder.setPaymentdate(requestCustomerOrder.getPaymentdate());
        customerOrder.setShippingaddress(requestCustomerOrder.getShippingaddress());
        customerOrder.setOrderstatus("confirm");
        orderRepository.save(customerOrder);

        RequestCustomerOrderItem requestCustomerOrderItem = new RequestCustomerOrderItem();
        List<RequestCustomerOrderItem> requestCustomerOrderItemList = new ArrayList<>();
        for(RequestCustomerOrderItem item : requestCustomerOrder.getRequestCustomerOrderItemList()){
            CustomerOrderItem customerOrderItem = new CustomerOrderItem();
            customerOrderItem.setProductid(item.getProductid());
            customerOrderItem.setQty(item.getQty());
            customerOrderItem.setPrice(item.getPrice());
            customerOrderItemRepository.save(customerOrderItem);

        }


        return "Success";
    }

}
