package com.zjl.study.shiroabc.controller;

import com.zjl.study.shiroabc.entity.Flower;
import com.zjl.study.shiroabc.service.FlowerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class IndexController {

    @Autowired
    private FlowerService flowerService;

    @RequestMapping("login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("register")
    public String registerPage() {
        return "register";
    }

    @RequestMapping("index")
    public String indexPage() {
        return "index";
    }

    @RequestMapping("dologin")
    public String doLogin(Flower flower) {
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.login(new UsernamePasswordToken(flower.getUsername(), flower.getPassword()));
        }  catch (Exception ex) {
            ex.printStackTrace();
            return "redirect:login";
        }
        return "redirect:index";
    }

    @RequestMapping("logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:login";
    }

    @RequestMapping("doregister")
    public String doRegister(Flower flower) {
        try {
            flowerService.saveFlower(flower);
            return "redirect:login";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "redirect:register";
        }
    }

}
