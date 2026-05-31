package BookManager;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.FileOutputStream;

public class Logger {
    public static void log(String message){
        String timestap = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logLine = "["+timestap+"]"+message;
        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("log.txt",true),"utf-8"))){
            
            writer.write(logLine);
            writer.newLine();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
