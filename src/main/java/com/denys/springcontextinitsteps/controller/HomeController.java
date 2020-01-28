package com.denys.springcontextinitsteps.controller;

import com.denys.springcontextinitsteps.models.MyBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@Slf4j
@RestController
public class HomeController {

    @Autowired
    ApplicationContext applicationContext;

    @GetMapping("/color")
    public void checkCustomFactoryBean() {
        Color color1 = new Color(0, 0, 0);
        log.info("default color: " + color1.getRGB());

        Color color = applicationContext.getBean(Color.class);
        log.info("Color from custom FactoryBean: " + color.getRGB());
    }

    @GetMapping("/mybean")
    public void checkMyBean() {
        MyBean myBean = applicationContext.getBean(MyBean.class);
        log.info("my bean: " + myBean.toString());
    }
}
