package ru.javarush.ceasarcypher.moskvitina;

import ru.javarush.ceasarcypher.moskvitina.controller.MainController;
import ru.javarush.ceasarcypher.moskvitina.view.console.ConsoleApp;
import ru.javarush.ceasarcypher.moskvitina.view.console.Menu;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu(sc);
        MainController mainController = new MainController();
        ConsoleApp app = new ConsoleApp(mainController, menu);
        app.run(args);



    }
}
