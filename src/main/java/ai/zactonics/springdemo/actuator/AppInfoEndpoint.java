package ai.zactonics.springdemo.actuator;

import org.springframework.core.env.Environment;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "appinfo")
public class AppInfoEndpoint {

    private final Environment environment;

    public AppInfoEndpoint(Environment environment) {
        this.environment = environment;
    }

    @ReadOperation
    public AppInfo getAppInfo() {
        String appName = environment.getProperty("info.app.name");
        String appVersion = environment.getProperty("info.app.version");
        String appDescription = environment.getProperty("info.app.description");
        return new AppInfo(appName, appVersion, appDescription);
    }

    // Static inner class to hold the response structure
    public static class AppInfo {
        private final String name;
        private final String version;
        private final String description;

        public AppInfo(String name, String version, String description) {
            this.name = name;
            this.version = version;
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public String getVersion() {
            return version;
        }

        public String getDescription() {
            return description;
        }
    }
}