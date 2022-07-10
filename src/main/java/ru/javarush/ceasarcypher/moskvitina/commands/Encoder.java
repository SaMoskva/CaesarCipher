package ru.javarush.ceasarcypher.moskvitina.commands;

import ru.javarush.ceasarcypher.moskvitina.entity.Result;
import ru.javarush.ceasarcypher.moskvitina.entity.ResultCode;
import ru.javarush.ceasarcypher.moskvitina.exceptions.ApplicationException;
import ru.javarush.ceasarcypher.moskvitina.util.KeyCalculate;
import ru.javarush.ceasarcypher.moskvitina.util.PathFinder;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import static ru.javarush.ceasarcypher.moskvitina.constants.Dictionary.*;
import static ru.javarush.ceasarcypher.moskvitina.constants.FileNames.*;

public class Encoder implements Action {
    @Override
    public Result execute(String[] parameters) {
        //TODO логику зашифровки данных
        String txtFile = "".equals(parameters[0]) ? ENCODED : parameters[0];
        String encodedFile = "".equals(parameters[1]) ? ENCODED : parameters[1];
        int key = KeyCalculate.getKey(Integer.parseInt(parameters[2].isEmpty() ? ENCODED : parameters[2]), charList.size());
        Path readFrom = Path.of(PathFinder.getRoot() + txtFile);
        Path writeTo = Path.of(PathFinder.getRoot() + encodedFile);
        List<String> result = new ArrayList<>();
        String str = "";
        try {
            List<String> strings = Files.readAllLines(readFrom);
            for (String line : strings) {
                String newLine = "";
                for (int j = 0; j < line.length(); j++) {
                    char letter = Character.toLowerCase(line.charAt(j));
                    if (charList.contains(letter)) {
                        int index = charList.indexOf(letter) + key;
                        if (index >= charList.size() - 1) {
                            index = Math.abs(charList.size() - index);
                        }
                        char newLetter = charList.get(index);
                        newLine += Character.toString(newLetter);
                    }
                }
                result.add(newLine);
            }


            for (String s : result) {
                str += s + "\n";
                Files.writeString(writeTo, str);
            }

        } catch (IOException e) {
            throw new ApplicationException("Файл по пути " + readFrom + " не найден!", e);
        }
        return new Result(ResultCode.OK, "Файлик вот тут лежит " + writeTo);


    }
}
