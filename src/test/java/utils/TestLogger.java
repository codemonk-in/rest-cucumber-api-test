package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utility class for centralized test logging.
 * Outputs timestamped messages to standard output during test execution.
 */
public class TestLogger {

    private static final String LOG_FOLDER = "target/test-logs/";
    private static final String TIMESTAMP = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
    private static final String LOG_FILE = LOG_FOLDER + "test_log_" + TIMESTAMP + ".txt";

    static {
        try {
            java.nio.file.Files.createDirectories(java.nio.file.Paths.get(LOG_FOLDER));
        } catch (IOException e) {
            System.err.println("Failed to create log folder: " + e.getMessage());
        }
    }
    /**
     * Logs a message to the console with a timestamp.
     *
     * @param message The message to be logged
     */
    public static void log(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            String timestampedMessage = "[" + LocalDateTime.now() + "] " + message;
            writer.write(timestampedMessage);
            writer.newLine();
            System.out.println(timestampedMessage); // also log to console
        } catch (IOException e) {
            System.err.println("Failed to write to log file: " + e.getMessage());
        }
    }
}
