package com.nexign.springMessageSender.factory;

import java.lang.reflect.InvocationTargetException;

public class BeanFactory {
    public static <T> T getBean(Class<T> tClass) {
        try {
            return tClass.getDeclaredConstructor().newInstance();
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
}
