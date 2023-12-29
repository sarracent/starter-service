package com.claro.amx.sp.starterrestservice.business;

import com.claro.amx.sp.starterrestservice.model.prod.CellularsPlans;

public interface CellularsPlansBO {
    CellularsPlans getCellularPlans(String cellularNumber);
}
