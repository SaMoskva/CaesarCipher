package ru.javarush.ceasarcypher.moskvitina.commands;

import ru.javarush.ceasarcypher.moskvitina.entity.Result;
import ru.javarush.ceasarcypher.moskvitina.entity.ResultCode;
import ru.javarush.ceasarcypher.moskvitina.exceptions.ApplicationException;
import ru.javarush.ceasarcypher.moskvitina.util.KeyCalculate;
import ru.javarush.ceasarcypher.moskvitina.util.PathFinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static ru.javarush.ceasarcypher.moskvitina.constants.Dictionary.*;
import static ru.javarush.ceasarcypher.moskvitina.constants.FileNames.*;

public class Encoder implements Action {
    @Override
    public Result execute(String[] parameters) {
        String txtFile = "".equals(parameters[0]) ? ENCODED : parameters[0];
        String encodedFile = "".equals(parameters[1]) ? ENCODED : parameters[1];
        int key = KeyCalculate.getKey(Integer.parseInt(parameters[2].isEmpty() ? ENCODED : parameters[2]), charList.size());
        Path readFromFile = Path.of(PathFinder.getRoot() + txtFile);
        Path writeToFile = Path.of(PathFinder.getRoot() + encodedFile);
        StringBuilder result = new StringBuilder();
        try {
            List<String> strings = Files.readAllLines(readFromFile);

            for (String line : strings) {
                StringBuilder newLine = new StringBuilder();
                for (char character : line.toCharArray()) {
                    if (charList.contains(character)) {
                        int originalAlphabetPosition = charList.indexOf(character);
                        int newAlphabetPosition = Math.abs((originalAlphabetPosition + key) % charList.size());
                        char newCharacter = charList.get(newAlphabetPosition);
                        newLine.append(newCharacter);
                    } else {
                        newLine.append(character);
                    }
                }
                result.append(newLine).append( "\n");
            }
            Files.writeString(writeToFile, result);

        } catch (IOException e) {
            throw new ApplicationException("Файл по пути " + readFromFile + " не найден!", e);
        }
        return new Result(ResultCode.OK, "Файлик вот тут лежит " + writeToFile);


    }
}
