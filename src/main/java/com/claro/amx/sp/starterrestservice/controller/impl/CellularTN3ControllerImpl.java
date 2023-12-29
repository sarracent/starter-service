package com.claro.amx.sp.starterrestservice.controller.impl;

import com.claro.amx.sp.starterrestservice.annotations.auditable.AuditableApi;
import com.claro.amx.sp.starterrestservice.annotations.auditable.AuditableParamIgnore;
import com.claro.amx.sp.starterrestservice.annotations.auditable.AuditableReturn;
import com.claro.amx.sp.starterrestservice.controller.CellularTN3Controller;
import com.claro.amx.sp.starterrestservice.model.response.CellularTN3Response;
import com.claro.amx.sp.starterrestservice.model.response.CellularsResponse;
import com.claro.amx.sp.starterrestservice.service.CellularTN3Service;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.claro.amx.sp.starterrestservice.commons.resolver.CustomHeadersResolver.getHeadersMap;
import static com.claro.amx.sp.starterrestservice.commons.resolver.CustomHeadersResolver.validateHeaders;
import static com.claro.amx.sp.starterrestservice.constants.Constants.CHANNEL_NAME;
import static com.claro.amx.sp.starterrestservice.constants.Constants.SESSION_NAME;

@RestController
@AllArgsConstructor
public class CellularTN3ControllerImpl implements CellularTN3Controller {

    private CellularTN3Service cellularTN3Service;

    @Override
    @AuditableApi(
            description = "getCellularByCellularNumber Api",
            parameterIgnore = @AuditableParamIgnore(nameToAudit = "httpHeadersMap", type = Map.class),
            returnMethod = @AuditableReturn(type = CellularsResponse.class))
    public ResponseEntity<CellularTN3Response> getCellular(Map<String, Object> httpHeadersMap, String subId) {
        final Map<String, String> headersMap = getHeadersMap(httpHeadersMap);
        validateHeaders(headersMap);

        CellularTN3Response response = cellularTN3Service.getCustomersDetailsUsingGET(subId, headersMap.get(SESSION_NAME), headersMap.get(CHANNEL_NAME));

        return ResponseEntity.ok().body(response);

    }
}
