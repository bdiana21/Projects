package Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogText {
        public static final File fileInit = new File("log.txt");
        public static FileWriter file = null;

        static {
            try {
                file = new FileWriter("log.txt");
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        public static synchronized void log(String message) {
            try {
                file.write(message + "\n");
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static synchronized void close() {
            try {
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
