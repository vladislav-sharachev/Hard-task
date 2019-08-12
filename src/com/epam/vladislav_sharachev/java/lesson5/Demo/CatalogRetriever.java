package com.epam.vladislav_sharachev.java.lesson5.Demo;

import java.io.File;

/**
 * Created by Alexey_Zinovyev on 15-Aug-16.
 */
public class CatalogRetriever {
    public static void main(String[] args) {
        File dir = new File("d:\\");
        retrieveCatalogs(dir);
    }

    private static void retrieveCatalogs(File dir) {
        if(dir.isDirectory()){
            File[] files = dir.listFiles();
            if(files!=null){
                for(File file : files){
                    System.out.println(file.getAbsolutePath());
                    if(file.isDirectory()){
                        retrieveCatalogs(file);
                    }
                }
            }
        }
    }
}
