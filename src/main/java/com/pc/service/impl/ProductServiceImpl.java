package com.pc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pc.dao.ProductDAO;
import com.pc.entity.Product;
import com.pc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class ProductServiceImpl implements ProductService {
    @Autowired(required = false)
    private ProductDAO productDAO;
    @Override
    @Transactional(readOnly = true)
    public PageInfo<Product> select(Integer page,Integer limit) {
        PageHelper.startPage(page,limit);
        List<Product> products = productDAO.select();
        PageInfo<Product> productPageInfo = new PageInfo<>(products);
        return productPageInfo;
    }

    @Override
    public void delete(Integer[] ids) {
        productDAO.delete(ids);
    }

    @Override
    public void add(Product product) {
        productDAO.add(product);
    }

    @Override
    public Product selectOne(Integer id) {
        return productDAO.selectOne(id);
    }

    @Override
    public void update(Product product) {
        productDAO.update(product);
    }
}
