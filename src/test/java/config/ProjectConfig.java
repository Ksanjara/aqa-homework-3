package config;

import com.codeborne.selenide.Configuration;
import config.auth.AuthConfig;
import config.web.WebConfig;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ProjectConfig {
    private final WebConfig webConfig;
    private final AuthConfig authConfig;

    public ProjectConfig(WebConfig webConfig, AuthConfig authConfig) {
        this.webConfig = webConfig;
        this.authConfig = authConfig;
    }


    public void apiConfig() {
        RestAssured.baseURI = webConfig.baseUrl();
        RestAssured.defaultParser = Parser.JSON;
    }

    public void webConfig() {
        Configuration.baseUrl = webConfig.baseUrl();
        Configuration.browser = webConfig.browser().toString();
        Configuration.browserVersion = webConfig.browserVersion();
        Configuration.browserSize = webConfig.browserSize();
        Configuration.pageLoadStrategy = webConfig.pageLoadStrategy();
        if (webConfig.isRemote()) {
            Configuration.remote = webConfig.remoteUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
    }
}
