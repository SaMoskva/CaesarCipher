package ru.javarush.ceasarcypher.moskvitina.commands;

import ru.javarush.ceasarcypher.moskvitina.entity.Result;

public interface Action {
    Result execute(String[] parameters);
}
