package com.pc.controller;

import com.github.pagehelper.PageInfo;
import com.pc.entity.Product;
import com.pc.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("product")
public class ProductController {
    Logger logger = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private ProductService productService;
    @RequestMapping("select")
    @ResponseBody
    public Map select(Integer page,Integer limit){
        Map map = new HashMap();
        PageInfo<Product> productPageInfo = productService.select(page, limit);
        logger.debug(""+productPageInfo.getList());
        map.put("code",0);
        map.put("msg","");
        map.put("count",productPageInfo.getTotal());
        map.put("data",productPageInfo.getList());
        return map;
    }
    @RequestMapping("upload")
    @ResponseBody
    public Map upload(MultipartFile file){
        logger.debug(file.getOriginalFilename());
        Map map = new HashMap();
        try {
            file.transferTo(new File("E:\\imgs",file.getOriginalFilename()));
            map.put("code",0);
            map.put("msg","");
            map.put("data",file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
    @RequestMapping("add")
    @ResponseBody
    public Map add(Product product){
        Map map = new HashMap();
        logger.debug(""+product);
        try{
            productService.add(product);
            map.put("add",true);
        }catch (Exception e){
            map.put("add",false);
        }
        return map;
    }
    @RequestMapping("delete")
    @ResponseBody
    public Map delete(Integer[] ids){
        Map map = new HashMap();
        try{
            productService.delete(ids);
            map.put("delete",true);
        }catch (Exception e){
            map.put("delete",false);
        }
        return map;
    }
    @RequestMapping("selectOne")
    @ResponseBody
    public Product selectOne(Integer id){

        return productService.selectOne(id);
    }
    @RequestMapping("update")
    @ResponseBody
    public Map update(Product product){
        Map map = new HashMap();
        try{
            productService.update(product);
            map.put("update",true);
        }catch (Exception e){
            map.put("update",false);
        }
        return map;
    }
}
