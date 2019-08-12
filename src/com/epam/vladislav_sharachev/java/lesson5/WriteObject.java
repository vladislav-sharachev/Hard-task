package com.epam.vladislav_sharachev.java.lesson5;

import com.epam.vladislav_sharachev.java.lesson5.Vegetables.Potato;
import com.epam.vladislav_sharachev.java.lesson5.Vegetables.Tomato;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
    public static void main(String[] args) {

        Tomato tomato = new Tomato(18, "Tomato", 200);

        try {
            FileOutputStream fos = new FileOutputStream("foods.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(tomato);

            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
