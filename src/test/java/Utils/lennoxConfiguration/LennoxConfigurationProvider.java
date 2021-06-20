package Utils.lennoxConfiguration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.Properties;

public class LennoxConfigurationProvider {
    private static final Log logger = LogFactory.getLog(LennoxConfigurationProvider.class);
    private Properties properties;

    private Properties getProperties(String environment) throws IOException {
        String env = System.getProperty("ENV", environment);
        final Properties properties = new Properties();
        properties.load(this.getClass().getResourceAsStream("/env/" + env + ".properties"));
        return properties;
    }

    public LennoxConfiguration getConfiguration(String environment) {
        try {
            properties = getProperties(environment);
        } catch (IOException e) {
            logger.debug("No such environment: " + environment);
            e.printStackTrace();
        }
        return new LennoxConfiguration(properties);
    }
}
