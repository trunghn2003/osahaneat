package com.cybersoft.osahaneat.service;

import com.cybersoft.osahaneat.entity.*;
import com.cybersoft.osahaneat.entity.key.KeyOrderItem;
import com.cybersoft.osahaneat.payload.request.OrderRequest;
import com.cybersoft.osahaneat.repository.OrderItemRepository;
import com.cybersoft.osahaneat.repository.OrderRepository;
import com.cybersoft.osahaneat.service.impl.OrderServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService  implements OrderServiceImpl {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderItemRepository orderItemRepository;
    @Transactional
    @Override
    public boolean insertOrder(OrderRequest orderRequest) {
        try {
            Users users = new Users();
            users.setId(orderRequest.getUserID());
            Restaurant restaurant = new Restaurant();
            restaurant.setId(orderRequest.getResID());

            Orders orders = new Orders();
            orders.setUsers(users);
            orders.setRestaurant(restaurant);
            orderRepository.save(orders);

            List<OrderItem> items = new ArrayList<>();
            for(int idFood: orderRequest.getFoodIds()){
                Food food = new Food();
                food.setId(idFood);
                OrderItem orderItem = new OrderItem();
                KeyOrderItem keyOrderItem = new KeyOrderItem(orders.getId(),idFood);
                orderItem.setKeyOrderItem(keyOrderItem);
                items.add(orderItem);
            }
            orderItemRepository.saveAll(items);
            System.out.println("duoc");
            return true;
        }
        catch (Exception e){
            System.out.println("mat");
            return false;

        }
    }
}
