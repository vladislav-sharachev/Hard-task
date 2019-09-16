package com.epam.vladislav_sharachev.java.lesson7.task1.Anno;

import com.epam.vladislav_sharachev.java.lesson7.task1.Annotations.Service;

public class AnnotationProcessor {
    public static void main(String[] args) {
        inspectService(SimpleService.class);
        inspectService(LazyService.class);
        inspectService(String.class);
    }

    public static void inspectService(Class<?> service) {
        if (service.isAnnotationPresent(
                Service.class)) {
            Service ann =
                    service.getAnnotation(Service.class);
            System.out.println(ann.name());
        } else {
            System.out.println("Аннотация не найдена");
        }
    }
}