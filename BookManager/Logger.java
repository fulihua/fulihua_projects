package BookManager;

import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.FileWriter;

public class Logger {
    public static void log(String message){
        String timestap = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logLine = "["+timestap+"]"+message;
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt",true))){
            writer.write(logLine);
            writer.newLine();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
