package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader extends Properties {
    private static PropertyReader propertyReader;


    public static PropertyReader getReader(String filePath){
        if (propertyReader == null){
            propertyReader = new PropertyReader();
            try {
                propertyReader.load(new FileReader(filePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return propertyReader;
    }
}
