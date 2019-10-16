package com.pc.service;

import com.github.pagehelper.PageInfo;
import com.pc.entity.Product;

public interface ProductService {

    PageInfo<Product> select(Integer page, Integer limit);
    void delete(Integer[] id);
    void add(Product product);
    Product selectOne(Integer id);
    void update(Product product);
}
