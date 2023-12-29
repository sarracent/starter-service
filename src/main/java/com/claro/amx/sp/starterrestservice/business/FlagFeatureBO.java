package com.claro.amx.sp.starterrestservice.business;

import com.claro.amx.sp.starterrestservice.model.response.FlagFeatureResponse;

public interface FlagFeatureBO {

    FlagFeatureResponse callService(String cellularNumber, String sessionId);
}
