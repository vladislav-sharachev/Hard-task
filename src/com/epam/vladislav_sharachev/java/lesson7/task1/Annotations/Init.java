package com.epam.vladislav_sharachev.java.lesson7.task1.Annotations;

import java.lang.annotation.*;

@Inherited
@Target(ElementType.METHOD) //только метод
@Retention(RetentionPolicy.RUNTIME) //
public @interface Init {
    String thisVoid() default "Yes";
    boolean suppressException() default false;
}