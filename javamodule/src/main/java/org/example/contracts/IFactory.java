package org.example.contracts;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

public interface IFactory {
    Object generate(File file, Class toReturn) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;
}
