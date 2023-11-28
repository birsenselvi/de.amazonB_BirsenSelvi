package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    Properties prop = new Properties();
    String file;

    public PropertyReader(String fileName) {
        try {
            file = "src/test/resources/dataFiles/" + fileName + ".properties";
            FileReader fileReader = new FileReader(file);
            prop.load(fileReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static PropertyReader read(String fileName) {
        return new PropertyReader(fileName);
    }

    public static PropertyReader read() {
        return read("Config");
    }

    public String get(String key) {
        return prop.getProperty(key);
    }


    public void set(String key, String value) {
        prop.setProperty(key, value);
    }

    public void del(String key) {
        prop.remove(key);
    }
}
