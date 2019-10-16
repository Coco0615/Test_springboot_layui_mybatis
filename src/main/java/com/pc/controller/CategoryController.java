package com.pc.controller;

import com.github.pagehelper.PageInfo;
import com.pc.entity.Category;
import com.pc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @RequestMapping("select")
    @ResponseBody
    public Map select(Integer page,Integer limit){
        Map map = new HashMap();
        PageInfo<Category> categoryPageInfo = categoryService.select(page, limit);
        map.put("code",0);
        map.put("msg","");
        map.put("count",categoryPageInfo.getTotal());
        map.put("data",categoryPageInfo.getList());
        return map;
    }
    @RequestMapping("select1")
    @ResponseBody
    public List<Category> select1(){
        List<Category> categories = categoryService.select();
        return categories;
    }
    @RequestMapping("selectById")
    @ResponseBody
    public List<Category> selectById(Integer id){
        List<Category> categories = categoryService.selectById(id);
        return categories;
    }

}
