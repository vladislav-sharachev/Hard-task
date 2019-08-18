package com.epam.vladislav_sharachev.java.lesson7.task1.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface checkTitleIsOk {
    String info();
}

//@Inherited - все дочерние классы тоже получают аннотацию
//@Retention() - когда запускать
//@Target - к каким элементам класса применить, возможность ограничения