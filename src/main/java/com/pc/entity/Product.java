package com.pc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Product implements Serializable {
    private Integer book_id;
    private Integer cid; // integer references dd_category(category_id),
    private String book_name;
    private double book_price;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date groundingDate;
    private String book_state;
    private Integer inventory;
    private String author;
    private String press;
    private Integer editNum;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date print_date;
    private Integer print_count;
    private String isbn;
    private String word_count;
    private String page_count;
    private String styles;
    private String page;
    private String pack;
    private Integer salenum;
    private double custome_score;
    private String recommend;
    private String messages;
    private String author_msg;
    private String list;
    private String media_comment;
    private String imagePath;
    private String series_name;
    private double dangprice;
    private String product_image;
    private Category category;
}
