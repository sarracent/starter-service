package com.claro.amx.sp.starterrestservice.service;

import java.util.function.Supplier;

public interface Resilience4jService {
    <T> T executeCellulars(Supplier<T> operation);
}
