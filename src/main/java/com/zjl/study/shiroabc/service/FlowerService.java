package com.zjl.study.shiroabc.service;

import com.zjl.study.shiroabc.dao.FlowerDao;
import com.zjl.study.shiroabc.entity.Flower;
import com.zjl.study.shiroabc.utils.SaltUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("flowerService")
public class FlowerService {

    @Autowired
    private FlowerDao flowerDao;

    public Flower findByUsername(String username) {
        return flowerDao.findByUsername(username);
    }
    public void saveFlower(Flower flower){
        String salt = SaltUtils.getSalt(8);
        Md5Hash hash = new Md5Hash(flower.getPassword(), salt, 1024);
        flower.setSalt(salt);
        flower.setPassword(hash.toHex());
        flowerDao.saveFlower(flower);
    }

}
