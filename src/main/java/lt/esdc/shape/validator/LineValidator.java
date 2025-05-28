package lt.esdc.shape.validator;

public class LineValidator {
    private static final int EXPECTED_TOKEN_COUNT = 5;

    public boolean isValid(String line) {
        if (line == null || line.isBlank()) {
            return false;
        }

        String[] tokens = line.trim().split("\\s+");
        if (tokens.length != EXPECTED_TOKEN_COUNT) {
            return false;
        }

        try {
            double x = Double.parseDouble(tokens[0]);
            double y = Double.parseDouble(tokens[1]);
            double z = Double.parseDouble(tokens[2]);
            double radius = Double.parseDouble(tokens[3]);
            double height = Double.parseDouble(tokens[4]);

            return radius > 0 && height > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
