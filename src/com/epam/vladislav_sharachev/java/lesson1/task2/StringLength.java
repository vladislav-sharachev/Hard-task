package com.epam.vladislav_sharachev.java.lesson1.task2; /* Влад Шарачев, 2 задание, 1 вариант */

import java.util.InputMismatchException;
import java.util.Scanner;

public class StringLength {
    public static void main(String[] args) {

        StringLength app = new StringLength();
        app.startStringLengthForMe();
    }

    public void startStringLengthForMe() {
            int n;
            while (true) {
                System.out.println("Введите количество строк");
                Scanner string = new Scanner(System.in);
                try {
                    n = string.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Введите числовое значение");
                }
            }
            String amount[] = new String[n];

            Scanner in = new Scanner(System.in);

            for (int i = 0; i < amount.length; i++) {
                System.out.println("Введите следующую строку ");
                amount[i] = in.nextLine();
            }
            int max = amount[0].length();
            int min = amount[0].length();
            int maxi = 0;
            int mini = 0;

            for (int i = 0; i < amount.length; i++)
                if (amount[i].length() < min) {
                    min = amount[i].length();
                    mini = i;
                } else if (amount[i].length() > max) {
                    max = amount[i].length();
                    maxi = i;
                }
            System.out.println("Самая маленькая строка в массиве это " + amount[mini] + " Она состоит из " + min + " символа(ов)");
            System.out.println("Самая большая строка в массиве это " + amount[maxi] + " Она состоит из " + max + " символа(ов)");
    }
}