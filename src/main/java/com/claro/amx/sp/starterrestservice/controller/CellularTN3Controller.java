package com.claro.amx.sp.starterrestservice.controller;

import com.claro.amx.sp.starterrestservice.model.response.CellularTN3Response;
import com.claro.amx.sp.starterrestservice.model.response.CellularsResponse;
import com.claro.amx.sp.starterrestservice.model.response.ServiceResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Map;

import static com.claro.amx.sp.starterrestservice.constants.Constants.*;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Tag(name = "Cellulars TN3 Controller", description = "The Cellulars Api")
@Validated
@RequestMapping(path = "/cellularsTN3", produces = {APPLICATION_JSON_VALUE})
public interface CellularTN3Controller {
    @GetMapping(produces = {APPLICATION_JSON_VALUE})
    @Operation(summary = "Get Cellular Info by cellular number from TN3", description = "Returns cellular information")
    @Parameters(value = {
            @Parameter(name = SESSION_NAME, in = ParameterIn.HEADER, required = true, description = SESSION_DESCR, schema = @Schema(type = "string")),
            @Parameter(name = CHANNEL_NAME, in = ParameterIn.HEADER, required = true, description = CHANNEL_DESCR, schema = @Schema(type = "string")),
            @Parameter(name = SERVICE_NAME, in = ParameterIn.HEADER, description = SERVICE_DESCR, schema = @Schema(type = "string")),
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = SUCCESS_CODE, description = SUCCESS_MSG, content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = CellularsResponse.class))),
            @ApiResponse(responseCode = BADREQUEST_CODE, description = BADREQUEST_MSG, content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ServiceResponse.class))),
            @ApiResponse(responseCode = INTERNALSERVER_CODE, description = INTERNALSERVER_MSG, content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ServiceResponse.class))),
    })
    ResponseEntity<CellularTN3Response> getCellular(
            @RequestHeader Map<String, Object> httpHeadersMap,
            @NotBlank @RequestParam String subId);
}
