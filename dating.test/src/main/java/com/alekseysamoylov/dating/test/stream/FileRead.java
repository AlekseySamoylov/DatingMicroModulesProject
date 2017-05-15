package com.alekseysamoylov.dating.test.stream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by alekseysamoylov on 5/15/17.
 */
public class FileRead {

    public static String process(String fileName, FileProcessor fileProcessor) {
        Path filePath = Paths.get(fileName);

        try {
            return fileProcessor.process(new BufferedReader(new FileReader(filePath.toFile())));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) throws IOException {
        process("constants.java", (bufferedReader -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }));
    }
}
