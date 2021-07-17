package com.zjl.study.shiroabc.dao;

import com.zjl.study.shiroabc.entity.Flower;

public interface FlowerDao {
    Flower findByUsername(String username);
    void saveFlower(Flower flower);
}
