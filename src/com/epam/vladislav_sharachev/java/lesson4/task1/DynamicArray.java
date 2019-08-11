package com.epam.vladislav_sharachev.java.lesson4.task1;

public class DynamicArray {
    public DynamicArray(int myValue) { //конструктор
        this.myArray = new Object[myValue];
    }
    public Object[] myArray;

    public int elements = 0; //количество элементов
    void add(Object elementToAdd) { //возможность добавления элементов в массив
        if (myArray.length <= elements) { //если длинна массива меньше содержащихся в нем элементов
            Object[] tempArray = myArray; //создаем 2-й массив
            myArray = new String[elements];
            for (int i = 0; i < tempArray.length; i++) {
                myArray[i] = tempArray[i];
            }
        }
        myArray[elements] = elementToAdd; // добавляет элемент в массив
        elements++; //добавляет +1 ячейку к размеру массива
    }

    void remove(int elementToRemove) { //возможность даления элементов из массива
        Object[] tempArray = myArray; //равняем старый массив с новым
        for (int i = 0; i < myArray.length; i++) {
            if (i < elementToRemove) {
                myArray[i] = tempArray[i];
            } else if (i > elementToRemove) {
                myArray[i - 1] = tempArray[i];
            }
        }
    }

    public Object get(int elements) { //получение элемента по индексу
        return myArray[elements];
    }

    @Override
    public String toString() {
        return "(" + myArray.length + ")";
    }

    public static void main(String[] args) {
        DynamicArray vector = new DynamicArray(8); //возможность задать начальный размер
        vector.add(0); //возможность добавления элемента в массив
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);
        vector.add(6);
        System.out.println("Num " + vector.get(4)); //получение элемента по индексу
        vector.remove(4);
        System.out.println("Num " + vector.get(4));
        System.out.println(vector.toString());
    }
}