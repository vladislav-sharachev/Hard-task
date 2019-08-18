package com.epam.vladislav_sharachev.java.lesson7.task1;

import com.epam.vladislav_sharachev.java.lesson7.task1.Annotations.MethodInfo;
import com.epam.vladislav_sharachev.java.lesson7.task1.CheafCook;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationProcessor {

    public static void vv() {
        try {
            for (Method method : ToCook.class
                    .getClassLoader()
                    .loadClass(("com.epam.vladislav_sharachev.java.lesson7.task1.CheafCook"))
                    .getMethods())
                if (method.isAnnotationPresent(MethodInfo.class)) {
                    try {
                        for (Annotation annot : method.getDeclaredAnnotations()) {
                            System.out.println("Аннотация в методе " + method.getName() + " " + annot.toString());
                        }
                        MethodInfo methodAnno = method
                                .getAnnotation(MethodInfo.class);
                        if (methodAnno.revision() == 1) {
                            System.out.println("Метод с ревизией номер 1 = " + method.getName());
                        }

                    } catch (Throwable ex) {
                        ex.printStackTrace();
                    }
                }
        } catch (SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }





    public static void main(String[] args) {
 /*       inspectService(CheafCook.class);
        inspectService(Product.class);
        inspectService(ToCook.class);

        ToCook a = new ToCook();
        Class<ToCook> aclass = ToCook.class; */


    //  Class b = Class.forName("java.lang.Byte");

/*    static void inspectService(Class<?> service) {

 /*       boolean isAnnotationPresent(Class<? extends Annotation > ann);
        if (service.isAnnotationPresent(CheafCook.class)) {
            CheafCook ann = service.getAnnotations(CheafCook.class);
        } */



    }
}
