package com.zjl.study.shiroabc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Flower {
    private Integer id;
    private String username;
    private String password;
    private String salt;
}
