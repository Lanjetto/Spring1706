package com.nexign.springMessageSender.context;

import com.nexign.springMessageSender.factory.BeanFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ApplicationContext {
    private BeanFactory beanFactory;

    private final Map<Class<?>, Object> cache = new HashMap<>();

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public <T> T getBean(Class<T> tClass) {
        if (cache.containsKey(tClass)) {
            return (T) cache.get(tClass);
        }
        T bean = beanFactory.getBean(tClass);
        cache.put(tClass, bean);
        return bean;
    }
}
