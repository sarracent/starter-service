package com.claro.amx.sp.starterrestservice.controller.impl;

import com.claro.amx.sp.starterrestservice.controller.CacheController;
import com.claro.amx.sp.starterrestservice.model.response.ServiceResponse;
import com.claro.amx.sp.starterrestservice.service.CacheService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static com.claro.amx.sp.starterrestservice.constants.Constants.OK_MSG;
import static com.claro.amx.sp.starterrestservice.constants.Constants.ZERO_MSG;

@RestController
@AllArgsConstructor
public class CacheControllerImpl implements CacheController {


    private CacheService cacheService;

    @Override
    public ResponseEntity<ServiceResponse> deleteCache(String cache) {
        cacheService.deleteCache(cache);
        return ResponseEntity.ok().body(new ServiceResponse(ZERO_MSG,OK_MSG));


    }
}
