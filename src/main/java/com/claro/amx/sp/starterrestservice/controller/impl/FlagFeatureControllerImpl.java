package com.claro.amx.sp.starterrestservice.controller.impl;

import com.claro.amx.sp.starterrestservice.controller.FlagFeatureController;
import com.claro.amx.sp.starterrestservice.model.response.FlagFeatureResponse;
import com.claro.amx.sp.starterrestservice.service.FlagFeatureService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@AllArgsConstructor
public class FlagFeatureControllerImpl implements FlagFeatureController {

    private FlagFeatureService service;

    @Override
    public ResponseEntity<FlagFeatureResponse> callExternalService(Map<String, Object> httpHeadersMap, String cellularNumber) {
        return ResponseEntity.ok().body(service.callFlagFeatureService(cellularNumber, (String) httpHeadersMap.get("session-id")));
    }
}
