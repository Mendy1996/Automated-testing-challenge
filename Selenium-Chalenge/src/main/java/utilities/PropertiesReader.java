package utilities;

import java.io.FileInputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PropertiesReader {

    private static Logger log = LoggerFactory.getLogger(PropertiesReader.class);
    private static final String PROPERTY_FILEPATH = "src\\main\\resources\\config.properties";


    public static String getValue(String key) {
        Properties prop = loadProperties();
        assert prop != null;
        return prop.getProperty(key);
    }

    private static Properties loadProperties() {
        log.info("Loading from property..");
        Properties prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream(PROPERTY_FILEPATH);
            prop.load(fis);
            log.info("successfully data loaded from property..");
            return prop;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
