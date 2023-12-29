package com.claro.amx.sp.starterrestservice.controller.impl;


import com.claro.amx.sp.starterrestservice.annotations.auditable.AuditableApi;
import com.claro.amx.sp.starterrestservice.annotations.auditable.AuditableParamIgnore;
import com.claro.amx.sp.starterrestservice.annotations.auditable.AuditableReturn;
import com.claro.amx.sp.starterrestservice.controller.CellularsController;
import com.claro.amx.sp.starterrestservice.model.request.CellularsRequest;
import com.claro.amx.sp.starterrestservice.model.response.CellularsResponse;
import com.claro.amx.sp.starterrestservice.service.CellularsService;
import com.claro.amx.sp.starterrestservice.service.Resilience4jService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.claro.amx.sp.starterrestservice.commons.resolver.CustomHeadersResolver.getHeadersMap;
import static com.claro.amx.sp.starterrestservice.commons.resolver.CustomHeadersResolver.validateHeaders;
import static com.claro.amx.sp.starterrestservice.constants.Constants.OK_MSG;
import static com.claro.amx.sp.starterrestservice.constants.Constants.ZERO_MSG;

@RestController
@AllArgsConstructor
public class CellularsControllerImpl implements CellularsController {

    private final CellularsService cellularsService;
    private final Resilience4jService resilience4JService;

    @Override
    @AuditableApi(
            description = "getCellularByCellularNumber Api",
            parameterIgnore = @AuditableParamIgnore(nameToAudit = "httpHeadersMap", type = Map.class),
            returnMethod = @AuditableReturn(type = CellularsResponse.class))
    public ResponseEntity<CellularsResponse> getCellular(
            final Map<String, Object> httpHeadersMap,
            final String cellularNumber) {

        final Map<String, String> headersMap = getHeadersMap(httpHeadersMap);
        validateHeaders(headersMap);

        var request = CellularsRequest.builder().cellularNumber(cellularNumber).build();
        var response = CellularsResponse.builder()
                .cellularsPlans(resilience4JService.executeCellulars(() -> cellularsService.getCellularPlans(request)))
                .resultCode(ZERO_MSG)
                .resultMessage(OK_MSG)
                .build();

        return ResponseEntity.ok()
                .body(response);
    }
}
