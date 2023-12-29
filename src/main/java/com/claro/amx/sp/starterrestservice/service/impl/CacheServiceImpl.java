package com.claro.amx.sp.starterrestservice.service.impl;

import com.claro.amx.sp.starterrestservice.constants.Constants;
import com.claro.amx.sp.starterrestservice.dao.ccard.ParameterRepository;
import com.claro.amx.sp.starterrestservice.service.CacheService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service manager de caches
 */
@Service
@AllArgsConstructor
public class CacheServiceImpl implements CacheService {
    private ParameterRepository parameterRepository;
    @Override
    public void deleteCache(String cache) {
        if (cache.toUpperCase().compareTo(Constants.CACHE_ID_PARAMETERS) == 0)
            parameterRepository.deleteAll();

    }
}
