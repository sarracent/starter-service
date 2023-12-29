package com.claro.amx.sp.starterrestservice.service;

import com.claro.amx.sp.starterrestservice.model.prod.CellularsPlans;
import com.claro.amx.sp.starterrestservice.model.request.CellularsRequest;

public interface CellularsService {
    CellularsPlans getCellularPlans(CellularsRequest cellularsRequest);
}
