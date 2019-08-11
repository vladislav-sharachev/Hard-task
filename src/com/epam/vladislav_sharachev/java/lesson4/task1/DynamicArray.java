package com.epam.vladislav_sharachev.java.lesson4.task1;

public class DynamicArray {
    public DynamicArray(int myValue) { //конструктор
        this.data = new Object[myValue];
    }

    public Object[] data;
    public int size = 0;

    public int size() { //размер массива
        return size;
    }

    void add(Object indexToAdd) { //возможность добавления элементов в массив
        if (data.length <= size) { //если длинна массива меньше содержащихся в нем элементов
            Object[] tmp = data;
            data = new String[size];
            for (int i = 0; i < tmp.length; i++) {
                data[i] = tmp[i];
            }
        }
        data[size] = indexToAdd; // добавляет элемент в массив
        size++; //добавляет +1 ячейку к размеру массива
    }

    void remove(int toRemove) { //возможность добавления элементов в массив
        Object[] newArray = data; //равняем старый массив с новым
        for (int i = 0; i < data.length; i++) {
            if (i < toRemove) {
                data[i] = newArray[i];
            } else if (i > toRemove) {
                data[i - 1] = newArray[i];
            }
        }
    }

    public Object get(int size) { //получение элемента по индексу
        return data[size];
    }

    @Override
    public String toString() {
        return "(" + data.length + ")";
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