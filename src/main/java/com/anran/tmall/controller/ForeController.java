package com.anran.tmall.controller;

/**
 * @author Anakin (Administrator)
 * @date 2018/8/21
 * @time 16:42
 * 描述    ${TODO}
 */

import com.anran.tmall.pojo.Category;
import com.anran.tmall.pojo.User;
import com.anran.tmall.service.*;
import com.anran.tmall.util.LogUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 前台界面
 */

@Controller
@RequestMapping("")
public class ForeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;


    @RequestMapping("forehome")
    public String home(Model model) {
        List<Category> cs = categoryService.list();
        productService.fill(cs);
        productService.fillByRow(cs);
        model.addAttribute("cs", cs);
        return "fore/home";
    }


    @RequestMapping("foreregister")
    public String register(Model model, User user) {
        boolean exist = userService.isExist(user.getName());
        //账号存在就跳转到注册页面
        if (exist) {
            model.addAttribute("msg", "您输入的账号已经存在,不能使用");
            model.addAttribute("user", null);
            return "/fore/register";
        }
        userService.add(user);
        return "redirect:registerSuccessPage";
    }

}
