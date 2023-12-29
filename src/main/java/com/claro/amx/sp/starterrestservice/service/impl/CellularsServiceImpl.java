package com.claro.amx.sp.starterrestservice.service.impl;


import com.claro.amx.sp.starterrestservice.business.CellularsPlansBO;
import com.claro.amx.sp.starterrestservice.constants.BusinessType;
import com.claro.amx.sp.starterrestservice.exception.impl.BusinessException;
import com.claro.amx.sp.starterrestservice.model.prod.CellularsPlans;
import com.claro.amx.sp.starterrestservice.model.request.CellularsRequest;
import com.claro.amx.sp.starterrestservice.service.CellularsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.claro.amx.sp.starterrestservice.constants.Errors.ERROR_BUSINESS_VALIDATION_BUSINESS;

@Service
@AllArgsConstructor
public class CellularsServiceImpl implements CellularsService {

    private final CellularsPlansBO cellularsPlansBO;

    public CellularsPlans getCellularPlans(CellularsRequest cellularsRequest) {
        final var cellularPlans = cellularsPlansBO.getCellularPlans(cellularsRequest.getCellularNumber());
        if (cellularPlans.getBusinessType().equalsIgnoreCase(BusinessType.CR.name()))
            throw new BusinessException(ERROR_BUSINESS_VALIDATION_BUSINESS.getCode(), String.format(ERROR_BUSINESS_VALIDATION_BUSINESS.getMessage(), cellularPlans.getCellularNumber(), cellularPlans.getBusinessType()));

        return cellularPlans;
    }
}
