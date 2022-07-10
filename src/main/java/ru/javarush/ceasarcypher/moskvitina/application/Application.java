package ru.javarush.ceasarcypher.moskvitina.application;

import ru.javarush.ceasarcypher.moskvitina.Result;
import ru.javarush.ceasarcypher.moskvitina.controller.MainController;

import java.util.Arrays;

public class Application {
    private final MainController mainController;

    public Application(MainController mainController) {
        this.mainController = mainController;
    }


    public Result run(String[] args) {
        String command = args[0];
        String[] parameters = Arrays.copyOfRange(args, 1, args.length);
        return mainController.execute(command, parameters);
    }
}
