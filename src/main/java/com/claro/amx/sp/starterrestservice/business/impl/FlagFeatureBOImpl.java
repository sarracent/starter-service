package com.claro.amx.sp.starterrestservice.business.impl;

import com.claro.amx.sp.starterrestservice.business.FlagFeatureBO;
import com.claro.amx.sp.starterrestservice.client.FlagFeatureClient;
import com.claro.amx.sp.starterrestservice.model.response.FlagFeatureResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FlagFeatureBOImpl implements FlagFeatureBO {

    private FlagFeatureClient flagFeatureClient;

    @Override
    public FlagFeatureResponse callService(String cellularNumber, String sessionId) {
        return flagFeatureClient.callFlagFeatureService(cellularNumber, sessionId);
    }
}
