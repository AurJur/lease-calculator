package lt.vln.tyz.leasecalculatortests.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Props {

    private static Properties properties;
    private static String propertyFileName = "global.properties";

    static {
        try (InputStream is = Props.class.getClassLoader().getResourceAsStream(propertyFileName)) {
            properties = new Properties();
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key, " no such key in '" + propertyFileName + "'.");
    }
}
