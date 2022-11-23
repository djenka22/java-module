package org.example.factory;

import lombok.extern.slf4j.Slf4j;
import org.example.contracts.IFactory;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@Slf4j
public class FileFactory implements IFactory {
    public Object generate(File file, Class toReturn) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Constructor constructor = toReturn.getConstructor(File.class);
        return constructor.newInstance(file);

    }
}
