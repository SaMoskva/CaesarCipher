package ru.javarush.ceasarcypher.moskvitina.controller;

import ru.javarush.ceasarcypher.moskvitina.commands.Action;
import ru.javarush.ceasarcypher.moskvitina.commands.Decoder;
import ru.javarush.ceasarcypher.moskvitina.commands.Encoder;

import java.util.Locale;

public enum Actions {

    ENCODE(new Encoder()),
    DECODE(new Decoder());

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action find(String command) {
        return Actions.valueOf(command.toUpperCase()).action;

    }
}
