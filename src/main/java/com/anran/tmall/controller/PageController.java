package com.anran.tmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Anakin(Administrator)
 * @date 2018/8/27 10:02
 * 描述     ${TODO}
 */

@Controller
@RequestMapping("")
class PageController {

    @RequestMapping("registerPage")
    public String registerPage() {
        return "fore/register";
    }

    @RequestMapping("registerSuccessPage")
    public String registerSuccessPage() {
        return "fore/registerSuccess";
    }

    @RequestMapping("loginPage")
    public String loginPage() {
        return "fore/login";
    }

    @RequestMapping("forealipay")
    public String alipay(){
        return "fore/alipay";
    }
}
