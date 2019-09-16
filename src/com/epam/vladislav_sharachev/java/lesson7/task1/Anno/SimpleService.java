package com.epam.vladislav_sharachev.java.lesson7.task1.Anno;


import com.epam.vladislav_sharachev.java.lesson7.task1.Annotations.Init;
import com.epam.vladislav_sharachev.java.lesson7.task1.Annotations.Service;


@Service(name = "Super Simple Service")
public class SimpleService {
    @Init
    public void initService() {
    }
}