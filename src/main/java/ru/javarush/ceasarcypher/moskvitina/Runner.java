package ru.javarush.ceasarcypher.moskvitina;

import ru.javarush.ceasarcypher.moskvitina.application.Application;
import ru.javarush.ceasarcypher.moskvitina.controller.MainController;

public class Runner {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        Application application = new Application(mainController);
        Result result = application.run(args);
        System.out.println(result);



    }
}
