package com.epam.vladislav_sharachev.java.lesson5.Demo;

import java.io.*;

/**
 * Created by Alexey_Zinovyev on 15-Aug-16.
 */
public class ReadBytesDemo {
    public static void main(String[] args) throws IOException {
        OutputStream output = new FileOutputStream("c:\\data\\3.txt");
        output.write("Hello World".getBytes());


        InputStream input = new FileInputStream("c:\\data\\3.txt");
        int data = input.read();
        while(data!= -1){
            data = input.read();
            System.out.println(data);
        }
        input.close();



    }
}
