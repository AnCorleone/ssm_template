package com.anran.tmall.service;

import com.anran.tmall.pojo.Order;

import java.util.List;

/**
 * @author Anakin (Administrator)
 * @date 2018/8/20
 * @time 16:49
 * 描述    ${TODO}
 */
public interface OrderService {
    String waitPay = "waitPay";
    String waitDelivery = "waitDelivery";
    String waitConfirm = "waitConfirm";
    String waitReview = "waitReview";
    String finish = "finish";
    String delete = "delete";

    void add(Order c);

    void delete(int id);

    void update(Order c);

    Order get(int id);

    List list();

}
