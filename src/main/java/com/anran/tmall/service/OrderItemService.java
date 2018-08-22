package com.anran.tmall.service;

import com.anran.tmall.pojo.Order;
import com.anran.tmall.pojo.OrderItem;

import java.util.List;

/**
 * @author Anakin (Administrator)
 * @date 2018/8/20
 * @time 16:50
 * 描述    ${TODO}
 */
public interface OrderItemService {
    void add(OrderItem c);

    void delete(int id);

    void update(OrderItem c);

    OrderItem get(int id);

    List list();

    void fill(List<Order> os);

    void fill(Order o);
}
