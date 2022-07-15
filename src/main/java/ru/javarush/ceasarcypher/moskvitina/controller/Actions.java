package ru.javarush.ceasarcypher.moskvitina.controller;

import ru.javarush.ceasarcypher.moskvitina.commands.*;

public enum Actions {

    ENCODE(new Encoder()),
    DECODE(new Decoder()),
    BRUTEFORCE(new Bruteforce()),
    EXIT(new Exit());

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action find(String command) {
        return Actions.valueOf(command.toUpperCase()).action;

    }
}
