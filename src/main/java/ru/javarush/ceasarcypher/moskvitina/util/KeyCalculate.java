package ru.javarush.ceasarcypher.moskvitina.util;

import static ru.javarush.ceasarcypher.moskvitina.constants.Dictionary.charList;
import static ru.javarush.ceasarcypher.moskvitina.constants.FileNames.ENCODED;

public class KeyCalculate {

    public static int getKey(int key, int size) {

        int evenPart = key / size;
        return Math.abs(evenPart * size - key);
    }
}
