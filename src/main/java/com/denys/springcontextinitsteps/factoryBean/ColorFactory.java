package com.denys.springcontextinitsteps.factoryBean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.Random;

/**
 * If you want custom configuration for bean - you should impl FactoryBean<T> and config. this.
 */
@Slf4j
@Component
public class ColorFactory implements FactoryBean<Color> {
    @Override
    public Color getObject() throws Exception {
        log.info("=======> FactoryBean<Color>");
        Random random = new Random();
        Color color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
        return color;
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
