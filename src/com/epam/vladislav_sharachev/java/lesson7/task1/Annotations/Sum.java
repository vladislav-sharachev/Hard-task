package com.epam.vladislav_sharachev.java.lesson7.task1.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.LOCAL_VARIABLE)
public @interface Sum {
    int sum() default 0;
}

//@Inherited - все дочерние классы тоже получают аннотацию
//@Retention() - когда запускать
//@Target - к каким элементам класса применить, возможность ограничения
