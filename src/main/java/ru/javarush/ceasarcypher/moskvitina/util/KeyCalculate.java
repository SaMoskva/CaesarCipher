package ru.javarush.ceasarcypher.moskvitina.util;

public class KeyCalculate {

    public static int getKey(int key, int size) {

        int evenPart = key / size;
        return Math.abs(evenPart * size - key);
    }
}
