package com.nexign.springMessageSender.factory;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class BeanFactory {

    private BeanFactory() {}

    private static final BeanFactory BEAN_FACTORY = new BeanFactory();

    public static BeanFactory getInstance() {
        return BEAN_FACTORY;
    }
    public <T> T getBean(Class<T> tClass) {
        Class<? extends T> implClass = tClass;
        if (implClass.isInterface()) {
            implClass = getImpl(implClass);
        }


        try {
            return implClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> Class<? extends T> getImpl(Class<T> tClass) {
        Reflections scanner = new Reflections("com.nexign.springMessageSender");
        Set<Class<? extends T>> subTypesOf = scanner.getSubTypesOf(tClass);
        if (subTypesOf.size() != 1) {
            throw new RuntimeException("0 или более 1 реализации");
        }
        return subTypesOf.iterator().next();
    }
}
