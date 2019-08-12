package com.epam.vladislav_sharachev.java.lesson5;

import com.epam.vladislav_sharachev.java.lesson5.Vegetables.Tomato;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Start {
    public static void main(String[] args) {

        Tomato tomato = new Tomato(18, "Tomato", 200);

        try (FileChannel channel = (FileChannel) Files.newByteChannel(Paths.get("C:\\aVlad\\file.bin"), // передаем ресурсу файл channel,
            //к нему применем статический метод newByteChannel, прописывается путь к файлу и действия
                StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            //Write - файл доступен для записи, create - создается если его нет
            ByteBuffer buffer = ByteBuffer.allocate(100);
            //буффер файлов и его емкость

            for (int i = 0; i < buffer.capacity(); i++) {
                buffer.put((byte)('A' + i));
                        //заполняем буффер
            }
            buffer.rewind(); //обнуление после записи в буффер
            channel.write(buffer);
        } catch (IOException exception) {
            System.out.println("Input / Output error");
        }
    }
}
