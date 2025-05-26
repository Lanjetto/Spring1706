package com.nexign.springMessageSender.factory;

import com.nexign.springMessageSender.Application;
import com.nexign.springMessageSender.annotations.Inject;
import com.nexign.springMessageSender.context.ApplicationContext;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class BeanFactory {

    private ApplicationContext context;

    public BeanFactory(ApplicationContext context) {
        this.context = context;
    }

    public  <T> T getBean(Class<T> clazz)  {
        Class<? extends T> tClass = clazz;
        if (tClass.isInterface()) {
            tClass = getImpl(clazz);
        }

        T bean = null;

        try {
            bean = tClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException
                 | IllegalAccessException
                 | InvocationTargetException
                 | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        Field[] declaredFields = tClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(Inject.class)) {
                declaredField.setAccessible(true);
                try {
                    declaredField.set(bean,context.getBean(declaredField.getType()) );
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return bean;
    }

    public  <T> Class<? extends T> getImpl(Class<T> clazz) {
        Reflections reflections = new Reflections("com.nexign.springMessageSender");
        Set<Class<? extends T>> subTypesOf = reflections.getSubTypesOf(clazz);
        if (subTypesOf.size() != 1) {
            throw new RuntimeException("0 or more realizations");
        }
        return subTypesOf.iterator().next();
    }
}
