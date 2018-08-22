package com.anran.tmall.service;

import com.anran.tmall.pojo.Product;
import com.anran.tmall.pojo.PropertyValue;

import java.util.List;

/**
 * @author Anakin (Administrator)
 * @date 2018/8/20
 * @time 9:35
 * 描述    ${TODO}
 */
public interface PropertyValueService {
    void init(Product product);

    void update(PropertyValue pv);

    PropertyValue get(int ptid, int pid);

    List<PropertyValue> list(int pid);
}
