package com.epam.vladislav_sharachev.java.lesson5;

import com.epam.vladislav_sharachev.java.lesson5.Product;
import com.epam.vladislav_sharachev.java.lesson5.Vegetables.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class _WriteObject {
    public static void main(String[] args) {

        Product tomato = new Tomato(18, "Помидор", 200);
        Product potato = new Potato(80, "Картофель", 200);
        Product garlic = new Garlic(20, "Чеснок", 149);
        Product carrot = new Carrot(41, "Морковь", 200);
        Product cabbage = new Cabbage(27, "Капуста", 500);
        Product beet = new Beet(43, "свекла", 500);



        try {
            FileOutputStream fos = new FileOutputStream("foods.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(tomato);
            oos.writeObject(potato);
            oos.writeObject(garlic);
            oos.writeObject(carrot);
            oos.writeObject(cabbage);
            oos.writeObject(beet);

            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}