package com.claro.amx.sp.starterrestservice.service.impl;

import com.claro.amx.sp.starterrestservice.business.FlagFeatureBO;
import com.claro.amx.sp.starterrestservice.exception.impl.TechnicalException;
import com.claro.amx.sp.starterrestservice.model.response.FlagFeatureResponse;
import com.claro.amx.sp.starterrestservice.service.FlagFeatureService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FlagFeatureServiceImpl implements FlagFeatureService {

    private FlagFeatureBO flagFeatureBO;

    @Override
    public FlagFeatureResponse callFlagFeatureService(String cellularNumber, String sessionId) {
        FlagFeatureResponse response = flagFeatureBO.callService(cellularNumber, sessionId);
        if (response == null || response.getFlagFeature().isBlank()) {
            throw new TechnicalException("", "");
        }
        return response;
    }
}
