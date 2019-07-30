package com.epam.vladislav_sharachev.java.lesson1.task1; /* Влад Шарачев, 1 задание, 3 вариант */

public class Arrays {

    public static void main(String[] args) {
        Arrays app = new Arrays();
        app.startArrayForMe();
    }
    public void startArrayForMe() {
        int[] array = new int[20];
        for (int i = 0; i <array.length; i++) {
            array[i] = (int) Math.round((Math.random() * 20) -10);
        }
        System.out.println(java.util.Arrays.toString(array)); /* Первоначальное задание 1 */
        for (int i = 0; i < array.length; i++) {
            if(array[i] < 1){
                array[i] = 0;
            }
        }
        System.out.print(java.util.Arrays.toString(array)); /* 3-й вариант задания */
    }
}