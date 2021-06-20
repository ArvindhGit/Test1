package Utils.lennoxConfiguration;

import java.util.Properties;

public class LennoxConfiguration {
    private String url;
    private String userName;
    private String password;

    public String getUrl() {
        return url;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public LennoxConfiguration(Properties properties) {
        this.url = properties.getProperty("url");
        this.userName = properties.getProperty("userName");
        this.password = properties.getProperty("password");
    }
}
