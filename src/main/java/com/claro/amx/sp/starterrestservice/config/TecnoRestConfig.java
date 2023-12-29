package com.claro.amx.sp.starterrestservice.config;

import com.claro.amx.sp.starterrestservice.exception.impl.InternalException;
import com.claro.amx.sp.tecnoosrestclient.invoker.ApiClientContext;
import com.claro.amx.sp.tecnoosrestclient.invoker.configuration.ApiClientConfigurationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;
import java.util.Properties;

@Configuration
@PropertySource("classpath:${eai.configuration-properties}")
@ConfigurationProperties(prefix = "tecnorestclient")
public class TecnoRestConfig {
    private static ApiClientContext apiClientContext;

    @Value("${tecnorestclient.username:-}")
    private String tecnorest_username;

    @Value("${tecnorestclient.password:-}")
    private String tecnorest_password;

    @Value("${tecnorestclient.oauthencryptorclass:-}")
    private String tecnorest_oauthencryptorclass;

    @Value("${tecnorestclient.authenabled:-}")
    private String tecnorest_authenabled;

    @Value("${tecnorestclient.loginpath:-}")
    private String tecnorest_loginpath;

    @Value("${tecnorestclient.balancespath:-}")
    private String tecnorest_balancespath;

    @Value("${tecnorestclient.detailspath:-}")
    private String tecnorest_detailspath;

    @Value("${tecnorestclient.minutestokenexpiration:0}")
    private String tecnorest_minutestokenexpiration;

    @Value("${tecnorestclient.connectionmillistimeout:0}")
    private String tecnorest_connectionmillistimeout;

    @Value("${tecnorestclient.readmillistimeout:0}")
    private String tecnorest_readmillistimeout;


    @PostConstruct
    public void initialize() {
        try {
            Properties prop = new Properties();
            // set the properties value
            prop.setProperty("tecnorestclient.username", tecnorest_username);
            prop.setProperty("tecnorestclient.password", tecnorest_password);
            prop.setProperty("tecnorestclient.loginpath", tecnorest_loginpath);
            prop.setProperty("tecnorestclient.oauthencryptorclass", tecnorest_oauthencryptorclass);
            prop.setProperty("tecnorestclient.authenabled", tecnorest_authenabled);
            prop.setProperty("tecnorestclient.minutestokenexpiration", tecnorest_minutestokenexpiration);
            prop.setProperty("tecnorestclient.connectionmillistimeout", tecnorest_connectionmillistimeout);
            prop.setProperty("tecnorestclient.readmillistimeout", tecnorest_readmillistimeout);

            prop.setProperty("tecnorestclient.balancespath", tecnorest_balancespath);
            prop.setProperty("tecnorestclient.detailstpath", tecnorest_detailspath);

            ApiClientContext.setPropertiesConfig(prop);

        } catch (ApiClientConfigurationException econfig) {
            throw new InternalException("5001", "Fallo");
        } catch (Exception e) {
            throw new InternalException("5002", "Fallo");
        }
    }
}

