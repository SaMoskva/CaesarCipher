package ru.javarush.ceasarcypher.moskvitina.controller;

import ru.javarush.ceasarcypher.moskvitina.commands.Action;
import ru.javarush.ceasarcypher.moskvitina.entity.Result;

public class MainController {
    public Result execute(String command, String[] parameters) {
        Action action = Actions.find(command);
        return action.execute(parameters);
    }
}
