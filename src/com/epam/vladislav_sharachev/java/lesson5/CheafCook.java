package com.epam.vladislav_sharachev.java.lesson5;

import com.epam.vladislav_sharachev.java.lesson5.Spices.PutSpice;
import com.epam.vladislav_sharachev.java.lesson5.Vegetables.Salad;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Scanner;

public class CheafCook {
    Product[] foods;

    public CheafCook(Product[] foods) {
        this.foods = foods;
    }


    public void getSorting() { //сортировка

        Arrays.sort(foods);
        for (int i = 0; i < foods.length; i++) {
            System.out.println(foods[i].getCalories() + " ккал - " + foods[i].getTitle());
        }
    }

    public void getMyEat() { //еда в холодильнике
        for (int i = 0; i < foods.length; i++) {
            System.out.println(foods[i].getTitle());
        }
    }

    public void getSum() { //сумма каллорий в пище

        int sum = 0;
        for (int i = 0; i < foods.length; ++i) {
            sum = sum + foods[i].getCalories();
        }
        System.out.println("Общая каллорийность продуктов: " + sum + " ккал");
    }


    public void getFind() { //поиск по диапазону по каллорий

        while (true) {

            int searchMin = getSort();

            int searchMax = getSort();

            for (int i = 0; i < foods.length; i++) {

                if (foods[i].getCalories() >= searchMin && foods[i].getCalories() <= searchMax)

                    System.out.println(+i + " " + foods[i].getTitle() + " - "

                            + foods[i].getCalories() + " ккал.");

            }

            if (searchMin > searchMax) {

                System.out.println("Первое число должно быть меньше второго");

            } else break;

        }

    }

    Scanner searchScanner = new Scanner(System.in);

    public int getSort() { //ввод для поиска по диапазону

        System.out.println("Введите диапазон");

        int sort;

        if (searchScanner.hasNextInt()) {

            sort = searchScanner.nextInt();

        } else {

            System.out.println("Введите только числовое значение.");

            searchScanner.next();

            sort = getSort();

        }

        return sort;

    }


    public void getQuest() { //меню цикла
        System.out.println("[1] - что в холодильнике " +
                "[2] - приготовить салат " +
                "[3] - приготовить суп " +
                "[4] - каллорийность продуктов в супе " +
                "[5] - сортировать овощи для салата по каллорийности " +
                "[6] - найти по диапазону каллорийности " +
                "[0] - выйти из игры");
    }

    public void outputSaladInfo(Salad toSalad) { //добавить овощи в салат
        toSalad.salad();
    }

    public void outputPutSpiceInfo(PutSpice toPutSpice) { //добавить специи в суп/салат

        toPutSpice.putSpice();
    }

    public void soupIsReady() { //сообщение о готовности
        System.out.println("Суп готов");
    }

    public void saladIsReady() { //сообщение о готовности
        System.out.println("Салат готов");
    }

    public void soupCook() { // добавить овощи в суп
        for (Product product : foods) {
            product.soup();
        }


    }


  /*  public void mySerial() {
        try (FileChannel channel = (FileChannel) Files.newByteChannel(Paths.get("C:\\aVlad\\file.txt"), // передаем ресурсу файл channel,
                //к нему применем статический метод newByteChannel, прописывается путь к файлу и действия
                StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            //Write - файл доступен для записи, create - создается если его нет
            ByteBuffer buffer = ByteBuffer.allocate(1000);
            //буффер файлов и его емкость

            for (int i = 0; i < buffer.capacity(); i++) {
                final ByteBuffer put = buffer.put((byte) (foods[i].getCalories()));
                //заполняем буффер
            }
            buffer.rewind(); //обнуление после записи в буффер
            channel.write(buffer);
        } catch (IOException exception) {
            System.out.println("Input / Output error");
        }
    } */

}