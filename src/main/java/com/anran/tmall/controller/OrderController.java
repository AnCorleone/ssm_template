package com.anran.tmall.controller;

import com.anran.tmall.pojo.Order;
import com.anran.tmall.service.OrderItemService;
import com.anran.tmall.service.OrderService;
import com.anran.tmall.util.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

/**
 * @author Anakin (Administrator)
 * @date 2018/8/20
 * @time 16:56
 * 描述    ${TODO}
 */
@Controller
@RequestMapping("")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderItemService orderItemService;

    @RequestMapping("admin_order_list")
    public String list(Page page, Model model) {
        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<Order> os = orderService.list();
        int total = (int) new PageInfo<>(os).getTotal();
        page.setTotal(total);

        orderItemService.fill(os);

        model.addAttribute("page", page);
        model.addAttribute("os", os);
        return "admin/listOrder";
    }

    /**
     * 发货
     *
     * @return
     */
    @RequestMapping("admin_order_delivery")
    public String delivery(Order order) {
        order.setDeliveryDate(new Date());
        order.setStatus(OrderService.waitConfirm);
        orderService.update(order);
        return "redirect:admin_order_list";
    }
}
