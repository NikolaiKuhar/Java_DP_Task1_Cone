package lt.esdc.shapes.parser;

import lt.esdc.shapes.exception.ConeException;

public interface ConeParser<T> {
    T parse(String line) throws ConeException;
}

