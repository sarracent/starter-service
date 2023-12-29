package com.claro.amx.sp.starterrestservice.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "flagfeature.api")
public class FlagFeatureClientConfig {

    public static final String FLAGFEATURE_API_CLIENT = "flagFeatureApi";
    private int timeout;
    private int readTimeout;
    private int writeTimeout;
    private int maxConnections;
    private String baseUrl;
    private int retryMaxAttemps;
    private int retryWaitDuration;
    private int timeoutDuration;
    private String urlName;


    private HttpClient getHttpClient() {
        return HttpClient
                .create(this.getConnectionProvider())
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, timeout)
                .doOnConnected(connection -> {
                    connection.addHandlerLast(new ReadTimeoutHandler(readTimeout, TimeUnit.MILLISECONDS));
                    connection.addHandlerLast(new WriteTimeoutHandler(writeTimeout, TimeUnit.MILLISECONDS));
                });
    }

    private ConnectionProvider getConnectionProvider() {
        return ConnectionProvider.builder(FLAGFEATURE_API_CLIENT).maxConnections(maxConnections).build();
    }

    @Bean(FLAGFEATURE_API_CLIENT)
    public WebClient getLocalhostClient() {
        return WebClient
                .builder()
                .clientConnector(new ReactorClientHttpConnector(getHttpClient()))
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultUriVariables(Collections.singletonMap("url", baseUrl))
                .build();
    }
}
