package org.example.factory;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@Slf4j
public class FileFactory {
    public static Object generate(File file, Class toReturn) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Constructor constructor = toReturn.getConstructor(File.class);
        return constructor.newInstance(file);

    }
}
