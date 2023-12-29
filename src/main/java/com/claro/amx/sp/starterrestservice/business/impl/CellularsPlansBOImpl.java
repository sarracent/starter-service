package com.claro.amx.sp.starterrestservice.business.impl;

import com.claro.amx.sp.starterrestservice.annotations.log.LogBO;
import com.claro.amx.sp.starterrestservice.business.CellularsPlansBO;
import com.claro.amx.sp.starterrestservice.dao.prod.CellularsPlansDAO;
import com.claro.amx.sp.starterrestservice.exception.impl.TechnicalException;
import com.claro.amx.sp.starterrestservice.model.prod.CellularsPlans;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static com.claro.amx.sp.starterrestservice.constants.Errors.ERROR_DATABASE_CELLULARS_PLANS_NOT_FOUND;


@Component
@AllArgsConstructor
public class CellularsPlansBOImpl implements CellularsPlansBO {

    private final CellularsPlansDAO cellularsPlansDAO;

    @LogBO
    @Override
    public CellularsPlans getCellularPlans(String cellularNumber) {
        final var cellularsPlansList = cellularsPlansDAO.getCellularPlansData(cellularNumber);
        if (cellularsPlansList == null || cellularsPlansList.isEmpty())
            throw new TechnicalException(ERROR_DATABASE_CELLULARS_PLANS_NOT_FOUND.getCode(), String.format(ERROR_DATABASE_CELLULARS_PLANS_NOT_FOUND.getMessage(), cellularNumber));

        return cellularsPlansList.get(0);
    }

}
