package com.claro.amx.sp.starterrestservice.client.impl;

import com.claro.amx.sp.starterrestservice.client.FlagFeatureClient;
import com.claro.amx.sp.starterrestservice.config.FlagFeatureClientConfig;
import com.claro.amx.sp.starterrestservice.exception.impl.ExternalException;
import com.claro.amx.sp.starterrestservice.model.response.FlagFeatureResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;

import static com.claro.amx.sp.starterrestservice.config.FlagFeatureClientConfig.FLAGFEATURE_API_CLIENT;
import static com.claro.amx.sp.starterrestservice.constants.Constants.*;
import static com.claro.amx.sp.starterrestservice.constants.Errors.ERROR_FLAG_FEATURE_SERVICE;

@Service
@AllArgsConstructor
public class FlagFeatureClientImpl implements FlagFeatureClient {

    @Qualifier(FLAGFEATURE_API_CLIENT)
    private final WebClient webClient;
    private final FlagFeatureClientConfig flagFeatureClientConfig;

    @Override
    public FlagFeatureResponse callFlagFeatureService(String cellularNumber, String sessionId) {

        var httpHeaders = new HttpHeaders();
        httpHeaders.add(FLAG_FEATURE_CELLULAR_NAME, cellularNumber);
        httpHeaders.add(SESSION_NAME, sessionId);
        httpHeaders.add(FLAG_FEATURE_FUNCIONALITY_NAME, FLAG_FEATURE_FUNCIONALITY);

        try {
            return webClient
                    .get()
                    .uri(uriBuilder -> uriBuilder
                            .path(flagFeatureClientConfig.getUrlName())
                            .build()
                    )
                    .headers(headers -> headers.addAll(httpHeaders))
                    .exchangeToMono(
                            x -> {
                                if (x.statusCode().is2xxSuccessful())
                                    return x.bodyToMono(FlagFeatureResponse.class);
                                return x.createException().flatMap(Mono::error);
                            })
                    .retryWhen(
                            Retry.backoff(flagFeatureClientConfig.getRetryMaxAttemps(), Duration.ofMillis(flagFeatureClientConfig.getRetryWaitDuration())))
                    .timeout(Duration.ofMillis(flagFeatureClientConfig.getTimeoutDuration()))
                    .onErrorResume(e -> {
                        if (e instanceof WebClientException) return Mono.error(e);
                        return Mono.error(new WebClientException(e.getMessage(), e) {
                        });
                    }).block();
        } catch (Exception e) {
            throw new ExternalException(ERROR_FLAG_FEATURE_SERVICE.getCode(),
                    String.format(ERROR_FLAG_FEATURE_SERVICE.getMessage(), cellularNumber, e.getClass().getSimpleName(), e.getMessage()));
        }
    }
}
