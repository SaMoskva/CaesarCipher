package ru.javarush.ceasarcypher.moskvitina.controller;

import ru.javarush.ceasarcypher.moskvitina.commands.Action;
import ru.javarush.ceasarcypher.moskvitina.entity.Result;
import ru.javarush.ceasarcypher.moskvitina.entity.ResultCode;
import ru.javarush.ceasarcypher.moskvitina.exceptions.ApplicationException;

public class MainController {
    public Result execute(String command, String[] parameters) {
        try {
            Action action = Actions.find(command);
            return action.execute(parameters);
        } catch (ApplicationException e) {
            //TODO логировать исключения
            return  new Result(ResultCode.ERROR, e.getMessage());
        }

    }
}
