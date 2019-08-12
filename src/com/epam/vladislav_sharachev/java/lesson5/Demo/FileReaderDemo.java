package com.epam.vladislav_sharachev.java.lesson5.Demo;

import java.io.*;

/**
 * Created by Alexey_Zinovyev on 15-Aug-16.
 */
public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        Writer writer = new FileWriter("c:\\data\\4.txt");
        writer.write("Summer Party");
        writer.close();

        Reader reader = new FileReader("c:\\data\\4.txt");
        int data = reader.read();
        while(data!=-1){
            char dataChar = (char) data;
            System.out.print(dataChar);
            data = reader.read();
        }


        //Reader readerSt = new InputStreamReader(oldAPI.getInputStream())

    }
}
