package com.pc.dao;

import com.pc.entity.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> select();
    void delete(Integer[] ids);
    void add(Product product);
    Product selectOne(Integer id);
    void update(Product product);
}
