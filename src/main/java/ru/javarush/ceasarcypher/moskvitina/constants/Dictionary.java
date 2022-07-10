package ru.javarush.ceasarcypher.moskvitina.constants;

public class Dictionary {
    private static final String RUS = "йцукенгшщзхъфывапролджэячсмитьбю";
    private static final String ENG = "qwertyuiopasdfghjklzxcvbnm";
    private static final String DIGITS = "1234567890";
    private static final String SYMBOLS = ",./@'!_-=+';{}[]";
    public static final String ALPHABET = RUS + RUS.toUpperCase() + ENG + ENG.toUpperCase() + SYMBOLS + DIGITS;
}
