package com.claro.amx.sp.starterrestservice.service.impl;

import com.claro.amx.sp.starterrestservice.business.CellularsTN3BO;
import com.claro.amx.sp.starterrestservice.exception.impl.TechnicalException;
import com.claro.amx.sp.starterrestservice.model.response.CellularTN3Response;
import com.claro.amx.sp.starterrestservice.service.CellularTN3Service;
import com.claro.amx.sp.tecnoosrestclient.models.DetailsResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.claro.amx.sp.starterrestservice.constants.Constants.OK_MSG;
import static com.claro.amx.sp.starterrestservice.constants.Constants.ZERO_MSG;
import static com.claro.amx.sp.starterrestservice.constants.Errors.ERROR_TN3_CELLULARS_NOT_FOUND;

@Service
@AllArgsConstructor
public class CellularTN3ServiceImpl implements CellularTN3Service {
    private CellularsTN3BO cellularsTN3BO;

    public CellularTN3Response getCustomersDetailsUsingGET(String subId, String sessionId, String channel) {
        DetailsResponse response = cellularsTN3BO.getCellularTN3Details(subId, sessionId, channel);
        if (response.getCustomerDetails() == null) {
            throw new TechnicalException(ERROR_TN3_CELLULARS_NOT_FOUND.getCode(), String.format(ERROR_TN3_CELLULARS_NOT_FOUND.getMessage(), subId));
        }
        return CellularTN3Response.builder()
                .customerDetails(response.getCustomerDetails())
                .resultCode(ZERO_MSG)
                .resultMessage(OK_MSG)
                .build();
    }
}
