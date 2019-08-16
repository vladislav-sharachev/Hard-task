package com.epam.vladislav_sharachev.java.lesson7.task1;

import java.lang.annotation.Annotation;

public class AnnotationProcessor {
    public static void main(String[] args) {
        inspectService(CheafCook.class);
        inspectService(Product.class);
        inspectService(ToCook.class);

        ToCook a = new ToCook();
        Class<ToCook> aclass = ToCook.class;

      //  Class b = Class.forName("java.lang.Byte");
    }

    static void inspectService(Class<?> service) {

 /*       boolean isAnnotationPresent(Class<? extends Annotation > ann);
        if (service.isAnnotationPresent(CheafCook.class)) {
            CheafCook ann = service.getAnnotations(CheafCook.class);
        } */


    }
}
