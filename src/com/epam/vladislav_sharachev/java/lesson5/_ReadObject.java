package com.epam.vladislav_sharachev.java.lesson5;

import com.epam.vladislav_sharachev.java.lesson5.Product;
import com.epam.vladislav_sharachev.java.lesson5.Vegetables.Garlic;
import com.epam.vladislav_sharachev.java.lesson5.Vegetables.Potato;
import com.epam.vladislav_sharachev.java.lesson5.Vegetables.Tomato;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.*;

public class _ReadObject {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("foods.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Product product = (Tomato) ois.readObject();
            Product product1 = (Potato) ois.readObject();
            Product product2 = (Garlic) ois.readObject();
            Product product3 = (Product) ois.readObject();
            Product product4 = (Product) ois.readObject();

            System.out.println("Следующие наименования скопированы в файл: ");
            System.out.println(product.title);
            System.out.println(product1.title);
            System.out.println(product2.title);
            System.out.println(product3.title);
            System.out.println(product4.title);
            System.out.println(product4.calories); // не работает так как transient


            ois.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}