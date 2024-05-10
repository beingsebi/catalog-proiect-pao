package services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;

public class CSVService {

    private static final String path = "history.csv";

    public static void WriteAction(String action) {
        String timestamp = LocalDateTime.now().toString();
        String path = "actions.csv";
        try {
            BufferedWriter buffer = new BufferedWriter(new FileWriter(path, true));
            buffer.write(action + "," + timestamp + "\n");
            buffer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
