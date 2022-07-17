package test;

import java.io.*;
import java.util.Properties;

public class FileProperties implements FileIO {

    private Properties properties = new Properties();

    @Override
    public void readFormFile(String filename) throws IOException {
        File file = new File(filename);
        InputStream inputStream = new FileInputStream(file);
        properties.load(inputStream);
        int i = 0;
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        File file = new File(filename);
        OutputStream outputStream = new FileOutputStream(file);
        properties.store(outputStream, "哈哈哈这是注释哈哈哈");
        int i = 0;
    }

    @Override
    public void setValue(String key, String value) {
        properties.setProperty(key, value);
    }

    @Override
    public String getValue(String key) {
        return properties.getProperty(key);
    }
}
