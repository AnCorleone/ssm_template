package com.anran.tmall.service.impl;

import com.anran.tmall.mapper.OrderMapper;
import com.anran.tmall.pojo.Order;
import com.anran.tmall.pojo.OrderExample;
import com.anran.tmall.pojo.User;
import com.anran.tmall.service.OrderService;
import com.anran.tmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Anakin (Administrator)
 * @date 2018/8/20
 * @time 16:59
 * 描述    ${TODO}
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    UserService userService;

    @Override
    public void add(Order c) {
        orderMapper.insert(c);
    }

    @Override
    public void delete(int id) {
        orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Order c) {
        orderMapper.updateByPrimaryKeySelective(c);
    }

    @Override
    public Order get(int id) {
        Order order = orderMapper.selectByPrimaryKey(id);
        return order;
    }

    @Override
    public List list() {
        OrderExample example = new OrderExample();
        example.setOrderByClause("id desc");
        List<Order> orders = orderMapper.selectByExample(example);
        setUser(orders);
        return orders;
    }

    private void setUser(List<Order> orders) {
        for (Order o : orders) {
            setUser(o);
        }
    }

    private void setUser(Order order) {
        Integer uid = order.getUid();
        User user = userService.get(uid);
        order.setUser(user);
    }

}
