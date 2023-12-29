package com.claro.amx.sp.starterrestservice.controller;

import com.claro.amx.sp.starterrestservice.model.response.FlagFeatureResponse;
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

@Tag(name = "External Service Controller", description = "Call External service")
@Validated
@RequestMapping("/service")
public interface FlagFeatureController {

    @GetMapping(value = "/flag", consumes = {APPLICATION_JSON_VALUE})
    @Operation(summary = "Call external Service", description = "Call service by cellularNumber")
    @Parameters(value = {
            @Parameter(name = SESSION_NAME, in = ParameterIn.HEADER, required = true, description = SESSION_DESCR, schema = @Schema(type = "string")),
            @Parameter(name = CHANNEL_NAME, in = ParameterIn.HEADER, required = true, description = CHANNEL_DESCR, schema = @Schema(type = "string"))
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = SUCCESS_CODE, description = SUCCESS_MSG, content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = FlagFeatureResponse.class))),
            @ApiResponse(responseCode = BADREQUEST_CODE, description = BADREQUEST_MSG, content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = FlagFeatureResponse.class))),
            @ApiResponse(responseCode = INTERNALSERVER_CODE, description = INTERNALSERVER_MSG, content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = FlagFeatureResponse.class))),
    })
    ResponseEntity<FlagFeatureResponse> callExternalService(
            @RequestHeader Map<String, Object> httpHeadersMap,
            @NotBlank @RequestParam String cellularNumber);
}
