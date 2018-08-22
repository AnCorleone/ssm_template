package com.anran.tmall.service;

import com.anran.tmall.pojo.Category;
import com.anran.tmall.pojo.Product;

import java.util.List;

/**
 * @author Anakin (Administrator)
 * @date 2018/8/16
 * @time 11:45
 * 描述    ${TODO}
 */
public interface ProductService {
    void add(Product product);

    void delete(int id);

    void update(Product product);

    Product get(int id);

    List<Product> list(int cid);

    /**
     * 产品管理显示一张图片
     *
     * @param product
     */
    void setFirstProductImage(Product product);

    void fill(List<Category> categorys);

    void fill(Category category);

    void fillByRow(List<Category> categorys);
}
