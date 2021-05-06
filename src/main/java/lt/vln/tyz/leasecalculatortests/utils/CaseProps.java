package lt.vln.tyz.leasecalculatortests.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CaseProps {

    private static Properties properties;
    private static String propertyFileName;

    public static String getProperty(String key) {
        return properties.getProperty(key, " no such key in '" + propertyFileName + "'.");
    }

    public static void setCase(String caseName) {
        propertyFileName = caseName + ".properties";
        try (InputStream is = CaseProps.class.getClassLoader().getResourceAsStream("cases/" + propertyFileName)) {
            properties = new Properties();
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
