import lt.esdc.shapes.exception.ConeException;
import lt.esdc.shapes.parser.ConeDataParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConeDataParserTest {

    private ConeDataParser parser;

    @BeforeEach
    void setUp() {
        parser = new ConeDataParser();
    }

    @Test
    void shouldParseValidLine() throws ConeException {
        String line = "1.0 2.0 3.0 4.0 5.0";
        double[] result = parser.parse(line);

        assertEquals(5, result.length);
        assertEquals(1.0, result[0]);
        assertEquals(5.0, result[4]);
    }

    @Test
    void shouldThrowExceptionForEmptyLine() {
        String line = " ";
        ConeException e = assertThrows(ConeException.class, () -> parser.parse(line));
        assertTrue(e.getMessage().contains("Пустая строка"));
    }

    @Test
    void shouldThrowExceptionForInvalidNumberOfTokens() {
        String line = "1 2 3";
        ConeException e = assertThrows(ConeException.class, () -> parser.parse(line));
        assertTrue(e.getMessage().contains("5 чисел"));
    }

    @Test
    void shouldThrowExceptionForInvalidNumberFormat() {
        String line = "1 2 3 abc 5";
        ConeException e = assertThrows(ConeException.class, () -> parser.parse(line));
        assertTrue(e.getMessage().contains("Ошибка разбора"));
    }

    @Test
    void shouldThrowExceptionForNullLine() {
        ConeException e = assertThrows(ConeException.class, () -> parser.parse(null));
        assertTrue(e.getMessage().contains("Пустая строка"));
    }
}
