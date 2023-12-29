package com.claro.amx.sp.starterrestservice.business;

import com.claro.amx.sp.tecnoosrestclient.models.DetailsResponse;

public interface CellularsTN3BO {

    DetailsResponse getCellularTN3Details(String subId, String sessionId, String channelId);
}
