package com.nexign.springMessageSender.context;

import com.nexign.springMessageSender.factory.BeanFactory;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {

    private BeanFactory factory;
    private final Map<Class<?>, Object> cache = new HashMap<>();


    public void setFactory(BeanFactory factory) {
        this.factory = factory;
    }

    public <T> T getBean(Class<T> clazz) {
        if (cache.containsKey(clazz)) {
            return (T) cache.get(clazz);
        }
        T bean = factory.getBean(clazz);
        System.out.println("Bean added to context");
        cache.put(clazz, bean);
        return bean;
    }


}
