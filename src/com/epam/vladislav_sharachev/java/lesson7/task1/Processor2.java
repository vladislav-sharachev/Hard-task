package com.epam.vladislav_sharachev.java.lesson7.task1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class Processor2 {
    public static void main(String[] args) {

        Class myClass = CheafCook.class; //получение объекта типа Class
        Package p = myClass.getPackage(); // получение пакета расположения класса
        System.out.println("package " + p.getName() + ";");

        Class[] interfaces = myClass.getInterfaces(); //выводим интерфейсы реализующие класс
        for (int i = 0, size = interfaces.length; i < size; i++) {
            System.out.println(i == 0 ? "implements " :  ", ");
            System.out.println(interfaces[i].getSimpleName());

        }
        System.out.println(" {");

        Field[] fields = myClass.getDeclaredFields(); //Выводим поля класса
        for (Field field : fields) {
            System.out.println("\t" + field.getModifiers() + field.getType() + " " + field.getName() + ";");
        }
        Method[] methods = myClass.getDeclaredMethods(); //выводим методы, аннотации класса
        for (Method m : methods) {
            Annotation[] annotations = m.getAnnotations();
            System.out.println("\t");
            for (Annotation a : annotations)
                System.out.println("@" + a.annotationType().getSimpleName() + " ");
            System.out.println();

            System.out.println("\t" + myClass.getModifiers() + m.getReturnType() + " " + m.getName() + " ");
            System.out.println(m.getParameterTypes());
            System.out.println(")");
        }
    }


}
