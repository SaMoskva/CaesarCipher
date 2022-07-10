package ru.javarush.ceasarcypher.moskvitina.commands;

import ru.javarush.ceasarcypher.moskvitina.entity.Result;
import ru.javarush.ceasarcypher.moskvitina.entity.ResultCode;
import ru.javarush.ceasarcypher.moskvitina.exceptions.ApplicationException;
import ru.javarush.ceasarcypher.moskvitina.util.PathFinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Encoder implements Action{
    @Override
    public Result execute(String[] parameters) {
        //TODO логику зашифровки данных
        String txtFile = parameters[0];
        String encodedFile = parameters[1];
        Path path = Path.of(PathFinder.getRoot() + txtFile);
        try {
            List<String> strings = Files.readAllLines(path);
            /*for (String string : strings) {
                System.out.println(string);
            }*/
        } catch (IOException e) {
            throw new ApplicationException("Файл по пути " + path + " не найден!", e);
        }
        return new Result(ResultCode.OK, "Файл прочитан!" + path);
    }
}
