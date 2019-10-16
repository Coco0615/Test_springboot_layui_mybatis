package com.pc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {
    private Integer id;
    private String email;
    private String nickname;
    private String password;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date create_data;
    private String state;
    private String authority;
}
