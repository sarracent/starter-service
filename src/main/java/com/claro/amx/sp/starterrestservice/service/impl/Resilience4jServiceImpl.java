package com.claro.amx.sp.starterrestservice.service.impl;

import com.claro.amx.sp.starterrestservice.service.Resilience4jService;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class Resilience4jServiceImpl implements Resilience4jService {

    private static final String CELLULARS_API = "cellulars";

    @Override
    @CircuitBreaker(name = CELLULARS_API)
    @RateLimiter(name = CELLULARS_API)
    @Bulkhead(name = CELLULARS_API)
    @Retry(name = CELLULARS_API)
    public <T> T executeCellulars(Supplier<T> operation) {
        return operation.get();
    }


}
