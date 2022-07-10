package ru.javarush.ceasarcypher.moskvitina;

import ru.javarush.ceasarcypher.moskvitina.toplevel.Application;
import ru.javarush.ceasarcypher.moskvitina.controller.MainController;
import ru.javarush.ceasarcypher.moskvitina.entity.Result;

public class Runner {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        Application application = new Application(mainController);
        Result result = application.run(args);
        System.out.println(result);



    }
}
