package com.denys.springcontextinitsteps.beanPostProcessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import java.util.Arrays;


@Slf4j
@Component
public class InjectRandomIntBeanPostProcessor implements BeanPostProcessor {

    /**
     * You can get Bean before init method like this.
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("postProcessBeforeInitialization::beanName = {}, beanClass = {}", beanName, bean.getClass().getSimpleName());

        var fields = bean.getClass().getDeclaredFields();
        Arrays.stream(fields)
                .filter(f -> f.isAnnotationPresent(InjectRandomInt.class))
                .forEach(field -> {
                    field.setAccessible(true);
                    InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
                    ReflectionUtils.setField(field, bean, getRandomIntInRange(annotation.min(), annotation.max()));
                });
        return bean;
    }

    /**
     * You can get Bean after init method like this.
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("postProcessAfterInitialization::beanName = {}, beanClass = {}", beanName, bean.getClass().getSimpleName());
        return bean;
    }

    private int getRandomIntInRange(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}
