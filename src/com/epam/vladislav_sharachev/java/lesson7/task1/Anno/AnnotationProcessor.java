package com.epam.vladislav_sharachev.java.lesson7.task1.Anno;

import com.epam.vladislav_sharachev.java.lesson7.task1.Annotations.Service;

import java.util.HashMap;
import java.util.Map;

public class AnnotationProcessor {
    Map<String, Object> serviceMap = new HashMap<>();

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        inspectService(SimpleService.class);
        inspectService(LazyService.class);
        inspectService(String.class);
        loadService("task1.Anno.LazyService");
        loadService("task1.Anno.SimpleService");
    }

    public static void inspectService(Class<?> service) {
        if (service.isAnnotationPresent(
                Service.class)) {
            Service ann =
                    service.getAnnotation(Service.class);
            System.out.println(ann.name());
        } else {
            System.out.println("Аннотация Service не найдена");
        }
    }
    static void loadService(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName(className);
        if (clazz.isAnnotationPresent(Service.class)) {
            Object serviceObj = clazz.newInstance();
        }
    }
}