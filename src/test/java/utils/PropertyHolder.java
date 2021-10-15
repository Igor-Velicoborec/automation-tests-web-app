package utils;

import lombok.experimental.UtilityClass;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

@UtilityClass
public class PropertyHolder {
    private static final Logger logger = LogManager.getLogger(PropertyHolder.class);
    public static final String TEST_PROPERTIES = "test.properties";
    public static final String CONFIG_PROPERTIES = "config.properties";
    private static final String PATH = "src/test/resources/";

    public static String getValueProperty(String key, String nameProperty) {
        logger.info("reader start");
        try (InputStream inputStream = new FileInputStream(PATH + nameProperty)) {
            Properties properties = new Properties();
            properties.load(inputStream);
            return (String) properties.get(key);
        } catch (Exception e) {
            logger.warn("reader crash");
            e.printStackTrace();
        }
        return null;
    }
}
