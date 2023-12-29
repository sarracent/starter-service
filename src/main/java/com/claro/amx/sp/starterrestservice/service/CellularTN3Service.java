package com.claro.amx.sp.starterrestservice.service;

import com.claro.amx.sp.starterrestservice.model.response.CellularTN3Response;

public interface CellularTN3Service {
    CellularTN3Response getCustomersDetailsUsingGET(String subId, String sessionId, String channel);
}
