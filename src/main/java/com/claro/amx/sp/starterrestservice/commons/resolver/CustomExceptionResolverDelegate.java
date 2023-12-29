package com.claro.amx.sp.starterrestservice.commons.resolver;

import com.claro.amx.sp.starterrestservice.constants.Errors;
import com.claro.amx.sp.starterrestservice.exception.CustomException;
import com.claro.amx.sp.starterrestservice.model.response.ServiceResponse;

public class CustomExceptionResolverDelegate {

    private CustomExceptionResolverDelegate() {
    }

    public static ServiceResponse buildServiceResponse(Exception ex) {
        if (ex instanceof CustomException) {
            CustomException customException = (CustomException) ex;
            return ServiceResponse.builder()
                    .resultCode(customException.getCode())
                    .resultMessage(customException.getMessage())
                    .build();
        } else {
            return ServiceResponse.builder()
                    .resultCode(Errors.ERROR_GENERAL.getCode())
                    .resultMessage(String.format(Errors.ERROR_GENERAL.getMessage(), ex.getMessage(), ex))
                    .build();
        }
    }

}