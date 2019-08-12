package com.epam.vladislav_sharachev.java.lesson5.Demo;

import java.io.*;

public class SerializationDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException { //тут мы создали объект
        FileOutputStream fos = new FileOutputStream("temp.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        TestSerial ts = new TestSerial();
        ts.version = 1000;
        oos.writeObject(ts);
        oos.flush();
        oos.close();

    //    TestSerial.version = 200;
        FileInputStream fis = new FileInputStream("temp.out");
        ObjectInputStream ois = new ObjectInputStream(fis);
/* TestSerial ts = (TestSerial)ois.readObject(); //десериализация
        System.out.println(ts.version); */
        TestSerial ts1 = (TestSerial)ois.readObject(); //десериализация
        System.out.println(ts1.version);


    }
}

class TestParent implements Serializable{}

class TestSerial extends TestParent {
// class TestSerial implements Serializable { // на объекты можно натравливать
    public int version; //значение не будет сериализовано
    public byte count = 0;
}