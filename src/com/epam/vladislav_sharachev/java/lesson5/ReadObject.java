package com.epam.vladislav_sharachev.java.lesson5;

import com.epam.vladislav_sharachev.java.lesson5.Vegetables.Potato;
import com.epam.vladislav_sharachev.java.lesson5.Vegetables.Tomato;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObject {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("foods.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Tomato tomato = (Tomato) ois.readObject();

            System.out.println(tomato);

            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
