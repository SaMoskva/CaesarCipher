package ru.javarush.ceasarcypher.moskvitina.view.console;

import java.util.Scanner;

import static ru.javarush.ceasarcypher.moskvitina.view.console.Messages.*;
import static ru.javarush.ceasarcypher.moskvitina.constants.FileNames.*;

public class Menu {
    private final Scanner scanner;


    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] getArgs() {
        int mode = getMode(scanner);
        String[] args = new String[HEADERS[mode].length];
        args[0] = HEADERS[mode][0][0];
        for (int i = 1; i < args.length; i++) {
            String header = HEADERS[mode][i][0];
            System.out.println(header);
            String input = scanner.nextLine();
            args[i] = "".equals(input.trim()) ? STANDARD_PARAMETERS[mode][i][0] : input;
        }
        return args;
    }

    private int getMode(Scanner scanner) {
        int mode;
        do{
            System.out.println(MESSAGE_SELECT_MODE);
            String input = scanner.nextLine();
            mode = switch (input) {
                case "1" -> 0;
                case "2" -> 1;
                case "5" -> 2;
                default -> {
                    System.out.println(INCORRECT_SELECTION);
                    yield -1;
                }
            };
        } while (mode < 0);
        return mode;
    }
}
