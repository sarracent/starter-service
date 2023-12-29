package com.claro.amx.sp.starterrestservice.client;

import com.claro.amx.sp.starterrestservice.model.response.FlagFeatureResponse;

public interface FlagFeatureClient {

    FlagFeatureResponse callFlagFeatureService(String cellularNumber, String sessionId);
}
