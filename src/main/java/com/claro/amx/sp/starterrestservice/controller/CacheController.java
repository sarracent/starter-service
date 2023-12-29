package com.claro.amx.sp.starterrestservice.controller;

import com.claro.amx.sp.starterrestservice.dao.ccard.ParameterRepository;
import com.claro.amx.sp.starterrestservice.model.response.ParameterResponse;
import com.claro.amx.sp.starterrestservice.model.response.ServiceResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.claro.amx.sp.starterrestservice.constants.Constants.*;
import static com.claro.amx.sp.starterrestservice.constants.Constants.INTERNALSERVER_MSG;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;


@Tag(name = "Caches Controller", description = "The Caches Parameters Api")
@RequestMapping(path = "/caches")
public interface CacheController {

    @DeleteMapping(value="/clean/{cache}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = SUCCESS_CODE, description = SUCCESS_MSG, content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ParameterResponse.class))),
            @ApiResponse(responseCode = BADREQUEST_CODE, description = BADREQUEST_MSG, content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ServiceResponse.class))),
            @ApiResponse(responseCode = INTERNALSERVER_CODE, description = INTERNALSERVER_MSG, content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ServiceResponse.class))),
    })
    public ResponseEntity<ServiceResponse> deleteCache(@PathVariable String cache);


}
