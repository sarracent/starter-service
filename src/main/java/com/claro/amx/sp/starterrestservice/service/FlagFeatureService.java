package com.claro.amx.sp.starterrestservice.service;

import com.claro.amx.sp.starterrestservice.model.response.FlagFeatureResponse;

public interface FlagFeatureService {

    FlagFeatureResponse callFlagFeatureService(String cellularNumber, String sessionId);

}
