package com.pc.dao;

import com.pc.entity.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> select();
    List<Category> select1();
    List<Category> selectById(Integer id);

}
