package com.anran.tmall.service;

import com.anran.tmall.pojo.User;

import java.util.List;

/**
 * @author Anakin (Administrator)
 * @date 2018/8/20
 * @time 14:32
 * 描述    ${TODO}
 */
public interface UserService {
    void add(User user);

    void delete(int id);

    void update(User user);

    User get(int id);

    List<User> list();

    boolean isExist(String name);
}
