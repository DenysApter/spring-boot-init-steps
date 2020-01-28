package com.denys.springcontextinitsteps.models;

import com.denys.springcontextinitsteps.beanPostProcessor.InjectRandomInt;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Data
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MyBean {

    @InjectRandomInt
    private int value1;

    @InjectRandomInt(min = 100, max = 200)
    private int value2;

    private int value3;

    public MyBean() {
        log.info("constructor in mybean");
    }

    static {
        log.info("==========>   static init block in mybean");
    }

    @PostConstruct
    public void init() {
        log.info("init in mybean");
    }
}

