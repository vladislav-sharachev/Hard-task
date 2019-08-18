package com.epam.vladislav_sharachev.java.lesson7.task1.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.LOCAL_VARIABLE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Search {

    int min();
    int max();

}
