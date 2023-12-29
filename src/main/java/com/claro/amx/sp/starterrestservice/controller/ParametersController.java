package com.claro.amx.sp.starterrestservice.controller;

import com.claro.amx.sp.starterrestservice.model.response.ParameterResponse;
import com.claro.amx.sp.starterrestservice.model.response.ServiceResponse;
import io.micrometer.core.annotation.Timed;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.claro.amx.sp.starterrestservice.constants.Constants.*;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Tag(name = "Parameters Controller", description = "The Parameters Api")
@Validated
@RequestMapping(path = "/parameters")
@Timed(value="parameter_method", extraTags = {"Version","1.0"})
public interface ParametersController {

    @GetMapping(value = "/name/{parameterName}", consumes = {APPLICATION_JSON_VALUE})
    @Operation(summary = "Get Parameter by name", description = "Get parameter information")
    @Parameters(value = {
            @Parameter(name = SESSION_NAME, in = ParameterIn.HEADER, required = true, description = SESSION_DESCR, schema = @Schema(type = "string")),
            @Parameter(name = CHANNEL_NAME, in = ParameterIn.HEADER, required = true, description = CHANNEL_DESCR, schema = @Schema(type = "string")),
            @Parameter(name = SERVICE_NAME, in = ParameterIn.HEADER, description = SERVICE_DESCR, schema = @Schema(type = "string")),
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = SUCCESS_CODE, description = SUCCESS_MSG, content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ParameterResponse.class))),
            @ApiResponse(responseCode = BADREQUEST_CODE, description = BADREQUEST_MSG, content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ServiceResponse.class))),
            @ApiResponse(responseCode = INTERNALSERVER_CODE, description = INTERNALSERVER_MSG, content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ServiceResponse.class))),
    })
    ResponseEntity<ParameterResponse> getParameterByName(
            @RequestHeader Map<String, Object> httpHeadersMap,
            @PathVariable String parameterName);

}
