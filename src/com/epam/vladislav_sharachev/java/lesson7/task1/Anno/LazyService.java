package com.epam.vladislav_sharachev.java.lesson7.task1.Anno;

import com.epam.vladislav_sharachev.java.lesson7.task1.Annotations.Init;
import com.epam.vladislav_sharachev.java.lesson7.task1.Annotations.Service;


@Service(name = "Super Lazy Service")
public class LazyService {
    @Init
    public void lazyInit() throws Exception {

    }
}