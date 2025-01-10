package config.auth;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/bslogin.properties"
})

public interface AuthConfig extends Config {
    @Key("bslogin")
    String bookStoreLogin();

    @Key("bspassword")
    String bookStorePassword();
}
