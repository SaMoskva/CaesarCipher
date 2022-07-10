package ru.javarush.ceasarcypher.moskvitina.commands;

import ru.javarush.ceasarcypher.moskvitina.entity.Result;
import ru.javarush.ceasarcypher.moskvitina.entity.ResultCode;
import ru.javarush.ceasarcypher.moskvitina.exceptions.ApplicationException;
import ru.javarush.ceasarcypher.moskvitina.util.PathFinder;

import java.io.FileReader;
import java.io.IOException;
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
        String encodedFile = parameters[1].isEmpty() ? ENCODED : parameters[1];
        int key = Integer.parseInt(parameters[2].isEmpty() ? ENCODED : parameters[2]);
        Path path = Path.of(PathFinder.getRoot() + txtFile);
        List<Character> result = new ArrayList<>();
        try {
            FileReader reader = new FileReader(String.valueOf(path));
            char[] buffer = new char[65536];
            while (reader.ready()) {
                int real = reader.read(buffer);
            }
            for (char c : buffer) {
                char letter = Character.toLowerCase(c);
                if (charList.contains(letter)) {
                    result.add(letter);
                }
            }
            System.out.println(result);

        } catch (IOException e) {
            throw new ApplicationException("Файл по пути " + path + " не найден!", e);
        }
        return new Result(ResultCode.OK, "Файл по пути " + path + " прочитан");


    }
}
