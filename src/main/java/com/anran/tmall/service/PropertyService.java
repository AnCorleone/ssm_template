package com.anran.tmall.service;

import com.anran.tmall.pojo.Property;

import java.util.List;

/**
 * @author Anakin (Administrator)
 * @date 2018/8/15
 * @time 19:33
 * 描述    ${TODO}
 */
public interface PropertyService {
    void add(Property c);

    void delete(int id);

    void update(Property c);

    Property get(int id);

    List<Property> list(int cid);
}
