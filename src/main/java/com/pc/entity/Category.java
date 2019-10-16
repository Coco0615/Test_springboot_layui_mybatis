package com.pc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category implements Serializable {
    private Integer category_id;
    private Integer parent_id;
    private String category_name;
    private Integer count;
    private String category_type;
    private List<Product> products;
}
