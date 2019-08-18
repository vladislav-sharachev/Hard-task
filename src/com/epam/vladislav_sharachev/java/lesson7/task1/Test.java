package com.epam.vladislav_sharachev.java.lesson7.task1;

import com.epam.vladislav_sharachev.java.lesson7.task1.Annotations.MethodInfo;
import com.epam.vladislav_sharachev.java.lesson7.task1.Annotations.RangeOfValues;
import com.epam.vladislav_sharachev.java.lesson7.task1.Annotations.checkTitleIsOk;
import com.epam.vladislav_sharachev.java.lesson7.task1.Excaptions.FieldNotFoundExcaption;
import com.epam.vladislav_sharachev.java.lesson7.task1.Spices.Pepper;
import com.epam.vladislav_sharachev.java.lesson7.task1.Vegetables.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    Product[] foods;

    public Test(Product[] foods) {
        this.foods = foods;
    }

    public void getMethodInfo() {
        try {
            for (Method method : ToCook.class
                    .getClassLoader()
                    .loadClass(("com.epam.vladislav_sharachev.java.lesson7.task1.CheafCook"))
                    .getMethods())
                if (method.isAnnotationPresent(MethodInfo.class)) {
                    try {
                        for (Annotation annot : method.getDeclaredAnnotations()) {
                        }
                        MethodInfo methodAnno = method
                                .getAnnotation(MethodInfo.class);
                        if (methodAnno.revision() == 1) {
                            System.out.println("WARNING! Имеется метод, который нужно пересмотреть в текущем релизе - "
                                    + "'" + method.getName() + "'");
                        } else if (methodAnno.revision() == 2) {
                        }
                    } catch (Throwable ex) {
                        ex.printStackTrace();
                    }
                }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void getRangeOfValues() {
        Class<Product> myProduct = Product.class;
        try {
            for (
                    Field method : Product.class
                    .getClassLoader()
                    .loadClass(("com.epam.vladislav_sharachev.java.lesson7.task1.Product"))
                    .getDeclaredFields())
                if (method.isAnnotationPresent(RangeOfValues.class)) {
                    try {
                        Annotation[] annotations = Product.class.getDeclaredField("calories").getAnnotations();

                        for (Annotation annot : annotations) {
                            if (annot instanceof RangeOfValues) {
                                for (int i = 0; i < foods.length; i++)
                                    if (((RangeOfValues) annot).max() < foods[i].getCalories() ||
                                            ((RangeOfValues) annot).min() > foods[i].getCalories()) {
                                        System.out.println("WARNING! Значение каллорий выходит за диапазон" +
                                                " от 0 до 250 для продукта - " + "'" + foods[i].getTitle() + "'");
                                    } else {
                                    }
                            }
                        }

                    } catch (Throwable ex) {
                        ex.printStackTrace();
                    }
                }
        } catch (SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void getCheckTitle() throws NoSuchFieldException, FieldNotFoundExcaption {
        Class<Product> myProduct = Product.class;
        try {
            for (
                    Field method : Product.class
                    .getClassLoader()
                    .loadClass(("com.epam.vladislav_sharachev.java.lesson7.task1.Product"))
                    .getDeclaredFields())
                if (method.isAnnotationPresent(checkTitleIsOk.class)) ;
            {

                Annotation[] annotations;
                annotations = Product.class.getDeclaredField("title0").getAnnotations();
                for (Annotation annot : annotations) {
                    if (annot instanceof checkTitleIsOk) ;
                    {
                        if (((checkTitleIsOk) annot).info().equals("title")) ;
                        {
                            System.out.println("Установлен рекомендуемый вариант названия строки title");
                        }
                    }
                }
            }
        } catch (SecurityException | ClassNotFoundException | FieldNotFoundExcaption e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws NoSuchFieldException {
        Product[] products = new Product[7];
        products[0] = new Beet(43, "Свекла", 500);
        products[1] = new Cabbage(27, "Капуста", 500);
        products[2] = new Carrot(41, "Морковь", 200);
        products[3] = new Garlic(149, "Чеснок", 20);
        products[4] = new Potato(80, "Картофель", 200);
        products[5] = new Tomato(18, "Помидор", 200);
        products[6] = new Pepper(1, "Перец", 1);
        Test test = new Test(products);

        test.getRangeOfValues();
        test.getMethodInfo();
        test.getCheckTitle();
    }

}