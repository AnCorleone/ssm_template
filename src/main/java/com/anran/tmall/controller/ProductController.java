package com.anran.tmall.controller;

import com.anran.tmall.pojo.Category;
import com.anran.tmall.pojo.Product;
import com.anran.tmall.service.CategoryService;
import com.anran.tmall.service.ProductService;
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
 * @date 2018/8/16
 * @time 11:45
 * 描述    ${TODO}
 */
@Controller
@RequestMapping("")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping("admin_product_list")
    public String list(int cid, Model model, Page page) {
        List<Product> ps = productService.list(cid);
        PageHelper.offsetPage(page.getStart(), page.getCount());
        Category c = categoryService.get(cid);
        int total = (int) new PageInfo<>(ps).getTotal();
        page.setTotal(total);
        page.setParam("&cid=" + c.getId());
        model.addAttribute("c", c);
        model.addAttribute("ps", ps);
        model.addAttribute("page", page);
        return "admin/listProduct";
    }

    @RequestMapping("admin_product_add")
    public String add(Product product, Model model) {
        product.setCreateDate(new Date());
        productService.add(product);
        return "redirect:/admin_product_list?cid=" + product.getCid();
    }

    @RequestMapping("admin_product_delete")
    public String delete(int id) {
        Product product = productService.get(id);
        productService.delete(id);
        return "redirect:/admin_product_list?cid=" + product.getCid();
    }

    @RequestMapping("admin_product_edit")
    public String edit(Model model, int id) {
        Product p = productService.get(id);
        Category c = categoryService.get(p.getCid());
        p.setCategory(c);
        model.addAttribute("product", p);
        return "admin/editProduct";
    }

    @RequestMapping("admin_product_update")
    public String update(Product product) {
        productService.update(product);
        return "redirect:/admin_product_list?cid=" + product.getCid();
    }

}
