package com.epam.vladislav_sharachev.java.lesson5.Demo;

import java.io.File;

/**
 * Created by Alexey_Zinovyev on 15-Aug-16.
 */
public class FileDemo {
    public static void main(String[] args) {
       /* File file = new File("c:\\data\\1.txt");
        System.out.println(file.exists());
        System.out.println(file.length());
        if(file.renameTo(new File("c:\\data\2.txt")));
        {
            System.out.println(file.exists());
            file.delete();
            System.out.println(file.exists());
        }*/

        File dir = new File("c:\\data\\newfolder");
        System.out.println(dir.exists());
        if(dir.mkdir()){
            System.out.println(dir.exists());
            System.out.println("It is directory : " + dir.isDirectory());
        }

        String[] fileNames = dir.list();
        for(String fileName : fileNames){
            System.out.println(fileName);
        }
        File[] files = dir.listFiles();
    }
}
