package com.claro.amx.sp.starterrestservice.controller.impl;


import com.claro.amx.sp.starterrestservice.annotations.auditable.AuditableApi;
import com.claro.amx.sp.starterrestservice.annotations.auditable.AuditableParamIgnore;
import com.claro.amx.sp.starterrestservice.annotations.auditable.AuditableReturn;
import com.claro.amx.sp.starterrestservice.controller.ParametersController;
import com.claro.amx.sp.starterrestservice.model.request.ParameterRequest;
import com.claro.amx.sp.starterrestservice.model.response.ParameterResponse;
import com.claro.amx.sp.starterrestservice.service.ParametersService;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.Date;
import java.util.Map;

import static com.claro.amx.sp.starterrestservice.commons.resolver.CustomHeadersResolver.getHeadersMap;
import static com.claro.amx.sp.starterrestservice.commons.resolver.CustomHeadersResolver.validateHeaders;
import static com.claro.amx.sp.starterrestservice.constants.Constants.*;

@RestController
@AllArgsConstructor
public class ParametersControllerImpl implements ParametersController {
    private final ParametersService parametersService;
    private PrometheusMeterRegistry meterRegistry;

    @Override
    @AuditableApi(
            description = "getParameterByName Api",
            parameterIgnore = @AuditableParamIgnore(nameToAudit = "httpHeadersMap", type = Map.class),
            returnMethod = @AuditableReturn(type = ParameterResponse.class))
    public ResponseEntity<ParameterResponse> getParameterByName(
            final Map<String, Object> httpHeadersMap,
            final String parameterName) {

        final long startTime = System.currentTimeMillis();
        final Map<String, String> headersMap = getHeadersMap(httpHeadersMap);
        validateHeaders(headersMap);

        var request = ParameterRequest.builder().parameterName(parameterName).build();
        var response = ParameterResponse.builder()
                .parametersList(parametersService.getParameter(request))
                .resultCode(ZERO_MSG)
                .resultMessage(OK_MSG)
                .build();
        //Meter  que me permite discriminar por channel, session, y response
        meterRegistry.timer("parameter_timer"
                        ,"Session-Id", headersMap.get("Session-Id")
                        ,"Channel-Id",headersMap.get("Channel-Id")
                        ,"responseCode", response.getResultCode()
                        ,"responseDesc" , response.getResultMessage())
                .record(Duration.ofMillis(System.currentTimeMillis() - startTime));

        return ResponseEntity.ok()
                .body(response);
    }

}
