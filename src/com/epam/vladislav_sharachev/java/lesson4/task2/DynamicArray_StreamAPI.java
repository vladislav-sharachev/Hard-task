package com.epam.vladislav_sharachev.java.lesson4.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DynamicArray_StreamAPI {


    public void createMillion_StreamAPI() {

    List myMillion = Stream.iterate(1, n -> n+1).limit(10).collect(Collectors.toList()); // Это Stream API
    List myMillionList = Arrays.asList(myMillion);
    myMillionList = new ArrayList(myMillionList);
    myMillionList.forEach(s -> System.out.println(s));
    }



    public static void main(String[] args) { // реализовано с коллекцией
        DynamicArray_StreamAPI vector = new DynamicArray_StreamAPI();
        vector.createMillion_StreamAPI();


    }

    }