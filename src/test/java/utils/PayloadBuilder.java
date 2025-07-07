package utils;

import java.nio.file.Files;
import java.nio.file.Paths;

public class PayloadBuilder {

    public static String loadJson(String fileName) {
        try {
            String path = "src/test/resources/testdata/" + fileName;
            return new String(Files.readAllBytes(Paths.get(path)));
        } catch (Exception e) {
            throw new RuntimeException("Failed to read payload file: " + fileName, e);
        }
    }
}
