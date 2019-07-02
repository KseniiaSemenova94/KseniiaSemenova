package hw4.utils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Properties;

public class FileUtils {

    public static Properties readUserFromFile(String filePath) {
        Properties properties = new Properties();
        try {
            properties.load(new InputStreamReader(new FileInputStream(filePath), Charset.forName("UTF-8")));
        } catch (FileNotFoundException f) {
            System.out.println("Error: file not found");
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
        return properties;
    }
}