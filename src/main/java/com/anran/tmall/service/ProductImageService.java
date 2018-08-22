package com.anran.tmall.service;

import com.anran.tmall.pojo.Product;
import com.anran.tmall.pojo.ProductImage;

import java.util.List;

/**
 * @author Anakin (Administrator)
 * @date 2018/8/18
 * @time 14:31
 * 描述    ${TODO}
 */

public interface ProductImageService {

    String type_single = "type_single";
    String type_detail = "type_detail";

    void add(ProductImage productImage);

    void delete(int id);

    void update(ProductImage productImage);

    ProductImage get(int id);

    List<ProductImage> list(int pid,String type);
}
