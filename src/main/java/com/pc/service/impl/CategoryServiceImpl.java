package com.pc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pc.dao.CategoryDAO;
import com.pc.entity.Category;
import com.pc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(readOnly = false)
public class CategoryServiceImpl implements CategoryService {
    @Autowired(required = false)
    private CategoryDAO categoryDAO;
    @Override
    @Transactional(readOnly = true)
    public PageInfo<Category> select(Integer page,Integer limit) {
        PageHelper.startPage(page,limit);
        List<Category> categories = categoryDAO.select();
        PageInfo<Category> categoryPageInfo = new PageInfo<>(categories);
        return categoryPageInfo;
    }

    @Override
    public List<Category> select() {
        List<Category> categories = categoryDAO.select1();
        return categories;
    }

    @Override
    public List<Category> selectById(Integer id) {
        return categoryDAO.selectById(id);
    }
}
