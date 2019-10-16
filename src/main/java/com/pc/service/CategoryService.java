package com.pc.service;

import com.github.pagehelper.PageInfo;
import com.pc.entity.Category;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
public interface CategoryService {

    PageInfo<Category> select(Integer page,Integer limit);
    List<Category> select();
    List<Category> selectById(Integer id);
}
