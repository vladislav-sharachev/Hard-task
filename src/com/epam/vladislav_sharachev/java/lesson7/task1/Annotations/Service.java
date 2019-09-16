package com.epam.vladislav_sharachev.java.lesson7.task1.Annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface Service {
    String name();

    boolean lazyLoad() default false;
}