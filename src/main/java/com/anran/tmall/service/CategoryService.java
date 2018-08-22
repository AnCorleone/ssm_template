package com.anran.tmall.service;

import com.anran.tmall.pojo.Category;

import java.util.List;

/**
 * @author Anakin (Administrator)
 * @date 2018/8/14
 * @time 11:47
 * 描述    ${TODO}
 */
public interface CategoryService {


    List<Category> list();

    void add(Category category);

    void deldete(int id);

    Category get(int id);

    void update(Category category);
}
