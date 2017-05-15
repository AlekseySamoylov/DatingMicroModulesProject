package com.alekseysamoylov.dating.test.stream;

import java.io.BufferedReader;

/**
 * Интерфейс для работы с файлами с помощью лямбда выражений
 */
@FunctionalInterface
public interface FileProcessor {

    public String process(BufferedReader bufferedReader);
}
