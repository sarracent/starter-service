package com.claro.amx.sp.starterrestservice.business.impl;

import com.claro.amx.sp.starterrestservice.business.CellularsTN3BO;
import com.claro.amx.sp.tecnoosrestclient.apis.DetailsApi;
import com.claro.amx.sp.tecnoosrestclient.models.DetailsResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CellularTN3BOImpl implements CellularsTN3BO {

    private DetailsApi detailsApi;

    @Override
    public DetailsResponse getCellularTN3Details(String subId, String sessionId, String channelId) {
        return detailsApi.getCustomersDetailsUsingGET(subId, sessionId, channelId, "");
    }
}